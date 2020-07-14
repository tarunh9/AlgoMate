package com.example.madproject_1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Random;

public class Prims_sub1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prims_sub1);
        Bitmap bg = Bitmap.createBitmap(720,1280,Bitmap.Config.ARGB_8888);
        final TextView tv = (TextView)findViewById(R.id.prims_tv);
        tv.setBackgroundDrawable(new BitmapDrawable(bg));
        Canvas canvas = new Canvas(bg);
        Paint paint = new Paint();//Circle
        paint.setColor(Color.GREEN);
        Paint paint1 = new Paint();//Text
        paint1.setTextSize(35);
        paint1.setColor(Color.BLACK);
        paint1.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        Paint paint2 = new Paint();//Line
        paint2.setStrokeWidth(3);
        paint2.setColor(Color.GRAY);
        Paint paint3 = new Paint();//Weights
        paint3.setTextSize(35);
        paint3.setColor(Color.RED);
        paint3.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        Random rand = new Random();
        //String inp="0 2 0 6 0, 2 0 3 8 5, 0 3 0 0 7, 6 8 0 0 9, 0 5 7 9 0";
        Intent in = getIntent();
        String inp = in.getStringExtra("input");
        String[] st=inp.split(",");
        for(int i=0;i<st.length;i++)
            System.out.println(st[i]);
        System.out.println();
        int n=st.length;
        int graph[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            String t[]=st[i].trim().split(" ");
            for(int j=0;j<n;j++)
                graph[i][j]=Integer.parseInt(t[j]);

        }
        int[][] pos=new int[n][2];
        pos[0][0]=70;
        pos[0][1]=70;
        canvas.drawCircle(70,70,30,paint);
        canvas.drawText("1",50,77,paint1);
        canvas.drawCircle(70,70+640,30,paint);
        canvas.drawText("1",50,77+640,paint1);
        for(int i=1;i<n;i++)
        {
            int xpos;
            int ypos;
            int flag=1;
            outerloop:
            for(int k=0;k<n;k++)
            {
                xpos=rand.nextInt((600 - 50) + 1) + 50;
                ypos=rand.nextInt((600 - 50) + 1) + 50;
                pos[i][0]=xpos;
                pos[i][1]=ypos;
                for(int j=0;j<i;j++)
                {
                    if (Math.abs(xpos-pos[j][0])>75 || Math.abs(ypos-pos[j][1])>100)
                        continue ;
                    else
                    {
                        flag=0;
                        break;
                    }
                }
                if(flag==1)
                    break ;
            }
            //canvas.drawLine(pos[i-1][0],pos[i-1][1],pos[i][0],pos[i][1],paint2);
            //canvas.drawCircle(xpos,ypos,30,paint);
            //canvas.drawCircle(xpos,ypos+640,30,paint);
            //canvas.drawText(String.valueOf(i+1),xpos-15,ypos+7,paint1);
            //canvas.drawText(String.valueOf(i+1),xpos-15,ypos+7+640,paint1);
            canvas.drawText("Question",300,30,paint1);
            canvas.drawText("Answer",300,640,paint1);
            //canvas.drawCircle(200,100,40,paint);
        }
        /*int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };*/
        //Question
        for(int i=0;i<graph.length-1;i++)
        {
            for(int j=i+1;j<graph[0].length;j++)
            {
                if(graph[i][j]>0)
                {
                    canvas.drawLine(pos[i][0],pos[i][1],pos[j][0],pos[j][1],paint2);
                    int midx=(pos[i][0]+pos[j][0])/2;
                    int midy=(pos[i][1]+pos[j][1])/2;
                    canvas.drawText(String.valueOf(graph[i][j]),midx,midy,paint3);
                }
            }
        }
        primMST(graph,n);
        String out=printMST(parent, graph,n);
        String[] s=out.split(" ");
        int[] arr2=new int[s.length];
        int i;
        for(i=0;i<s.length;i++)
            arr2[i]=Integer.parseInt(s[i]);
        /*for(i = 0; i<arr2.length; i=i+3)
        {
            canvas.drawLine(pos[arr2[i]][0],pos[arr2[i]][1],pos[arr2[i+1]][0],pos[arr2[i+1]][1],paint2);
        }*/
        //Answer
        for(i = 0; i<arr2.length; i=i+3)
        {
            canvas.drawLine(pos[arr2[i]][0],pos[arr2[i]][1]+640,pos[arr2[i+1]][0],pos[arr2[i+1]][1]+640,paint2);
            int midx=(pos[arr2[i]][0]+pos[arr2[i+1]][0])/2;
            int midy=(pos[arr2[i]][1]+pos[arr2[i+1]][1]+1280)/2;
            canvas.drawText(String.valueOf(arr2[i+2]),midx,midy,paint3);
        }
        for(i=0;i<n;i++)
        {
            int xpos=pos[i][0];
            int ypos=pos[i][1];
            canvas.drawCircle(xpos,ypos,30,paint);
            canvas.drawCircle(xpos,ypos+640,30,paint);
            canvas.drawText(String.valueOf(i+1),xpos-15,ypos+7,paint1);
            canvas.drawText(String.valueOf(i+1),xpos-15,ypos+7+640,paint1);
        }
    }
    //private static final int V = 5;
    static int parent[] = new int[100];
    int minKey(int[] key, Boolean[] mstSet, int V)
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    static String printMST(int parent[], int graph[][],int V)
    {
        String out="";
        int[][] output=new int[V][V];
        for(int i=0;i<V;i++)
            for(int j=0;j<V;j++)
                output[i][j]=0;
        //System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
        {	output[parent[i]][i]=graph[i][parent[i]];
            output[i][parent[i]]=graph[i][parent[i]];
            out+=parent[i] + " " + i + " " + graph[i][parent[i]]+" ";
        }
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                System.out.print(output[i][j]+"  ");
            }
            System.out.println();
        }
        return out;
    }

    void primMST(int graph[][],int V)
    {
        int key[] = new int[V];
        Boolean mstSet[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0; // Make key 0 so that this vertex is
        parent[0] = -1; // First node is always root of MST
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet,V);
            mstSet[u] = true;
            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
    }
}
