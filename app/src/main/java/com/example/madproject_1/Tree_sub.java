package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Tree_sub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_sub);
        Intent in = getIntent();
        String output = in.getStringExtra("input");
        LinearLayout vertical = (LinearLayout) findViewById(R.id.myVertical);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        String[] str = output.split(" ");
        int size = str.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = Integer.parseInt(str[i]);
        int n = (int)(Math.log(arr.length) / Math.log(2))+1;
        //System.out.println(n);
        int count=0;
        String out="";
        outerloop:
        for(int i=0;i<n;i++)
        {
            int sp=(int) (2*Math.pow(2, n-1-i));
            for(int j=0;j<Math.pow(2, i);j++)
            {
                if(count>=arr.length)
                    break outerloop;
                int z=(arr[count]+"").length();
                int s1=z/2;
                int s2=z-s1;
                for(int k=0;k<sp-s1;k++)
                    out+="  "; //System.out.print(" ");
                out+=arr[count];//System.out.print(arr[count]);
                count++;
                for(int k=0;k<sp-s2;k++)
                    out+="  ";//System.out.print(" ");

            }
            out+="\n\n";//System.out.println("\n");
        }
        final TextView ansTextView = new TextView(this);
        //ansTextView.setText("Answer :" +"\n");
        ansTextView.setTextSize(25);
        ansTextView.setLayoutParams(params);
        vertical.addView(ansTextView);
        ansTextView.setText(out);
    }
}

