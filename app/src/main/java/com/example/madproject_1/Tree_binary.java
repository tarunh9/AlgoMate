package com.example.madproject_1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Tree_binary extends AppCompatActivity {

    int size;
    String[] str;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_binary);
        Bitmap bg = Bitmap.createBitmap(720,1280,Bitmap.Config.ARGB_8888);
        TextView tv = (TextView)findViewById(R.id.tv_binary);
        tv.setBackgroundDrawable(new BitmapDrawable(bg));
        final Canvas canvas = new Canvas(bg);
        final Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        final Paint paint1 = new Paint();
        paint1.setTextSize(30);
        paint1.setColor(Color.BLACK);
        final Paint paint2 = new Paint();
        paint2.setColor(Color.GRAY);
        /*canvas.drawText("Rectangle",420,150,paint);
        canvas.drawRect(400,200,650,700,paint);
        canvas.drawText("Circle",150,200,paint);
        canvas.drawCircle(200,400,150,paint);
        canvas.drawText("Line",200,700,paint);
        canvas.drawLine(150,800,500,800,paint);
        canvas.drawLine(150,200,200,100,paint2);
        canvas.drawCircle(200,100,40,paint);
        canvas.drawCircle(150,200,40,paint);
        canvas.drawText("11",135,207,paint1);
        canvas.drawText("10",185,107,paint1);*/
        final EditText inp = (EditText) findViewById(R.id.edit_binary);
        Button submit = (Button)findViewById(R.id.bt_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=inp.getText().toString();
                String[] str = input.split(" ");
                int size = str.length;
                int[] arr = new int[size];
                for (int i = 0; i < size; i++)
                    arr[i] = Integer.parseInt(str[i]);
                //int[] arr={1,2,3,4,5,6,7,8,9,10,11};
                int l=arr.length;
                int [][] pos=new int[l][2];
                int n = (int)(Math.log(arr.length) / Math.log(2))+1;
                int count=0;
                String out="";
                outerloop:
                for(int i=0;i<n;i++)
                {
                    //int sp=(int) (2*Math.pow(2, n-1-i));

                    for(int j=0;j<Math.pow(2, i);j++)
                    {
                        if(count>=arr.length)
                            break outerloop;
                        int xpos=720*(2*j+1)/(int)(Math.pow(2,i+1));
                        int ypos=120*(i+1);
                        pos[count][0]=xpos;
                        pos[count][1]=ypos;
                        int pindex=(int)((count-1)/2);
                        canvas.drawLine(xpos,ypos,pos[pindex][0],pos[pindex][1],paint2);
                        canvas.drawCircle(xpos,ypos,25,paint);
                        canvas.drawText(String.valueOf(arr[count]),xpos-15,ypos+7,paint1);
                        canvas.drawCircle(pos[pindex][0],pos[pindex][1],25,paint);
                        canvas.drawText(String.valueOf(arr[pindex]),pos[pindex][0]-15,pos[pindex][1]+7,paint1);
                        count++;
                /*int z=(arr[count]+"").length();
                int s1=z/2;
                int s2=z-s1;
                for(int k=0;k<sp-s1;k++)
                    out+="  "; //System.out.print(" ");
                out+=arr[count];//System.out.print(arr[count]);
                count++;
                for(int k=0;k<sp-s2;k++)
                    out+="  ";//System.out.print(" ");*/

                    }
                    //out+="\n\n";//System.out.println("\n");
                }

            }
        });

        //tv.setText((out));
    }
}
