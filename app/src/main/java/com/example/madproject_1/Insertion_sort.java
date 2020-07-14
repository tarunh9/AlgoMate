package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.Gravity;

public class Insertion_sort extends AppCompatActivity {
    TextView t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_sort);
        Intent in = getIntent();
        String select = in.getStringExtra("select_key");
        LinearLayout vertical = (LinearLayout) findViewById(R.id.vertical_in);

        final TextView[] myTextViews = new TextView[1000];

        String inp = in.getStringExtra("array_key");

        String[] str = inp.split(" ");
        int size = str.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = Integer.parseInt(str[i]);

        /////////////////////////
        String output1 = "";
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //params.setMargins(60, 20, 10, 10);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        final TextView qTextView = new TextView(this);
        qTextView.setText("Question : " + inp + "\n");
        qTextView.setTextSize(30);
        qTextView.setLayoutParams(params);
        vertical.addView(qTextView);
        final TextView ansTextView = new TextView(this);
        ansTextView.setText("Answer :" +"\n");
        ansTextView.setTextSize(30);
        ansTextView.setLayoutParams(params);
        vertical.addView(ansTextView);
        int n = arr.length;
        int lines = -1;
        for (int i=1; i<n; ++i)
        {
            //System.out.println("Iteration:"+(i));
            int key = arr[i];
            int j = i-1;
            output1="";
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
                //printArray(arr);
            }
            arr[j+1] = key;
            lines+=1;
            for (int k = 0; k < n; k++)
                output1 += arr[k] + "   ";
            output1+="\n";
            final TextView rowTextView = new TextView(this);
            rowTextView.setText(output1);
            rowTextView.setTextSize(20);
            rowTextView.setLayoutParams(params);
            //rowTextView.setBackgroundResource(R.drawable.text_view_circle);
            vertical.addView(rowTextView);
            myTextViews[lines] = rowTextView;

        }
        ansTextView.setText("Answer : "+output1);

    }

}
