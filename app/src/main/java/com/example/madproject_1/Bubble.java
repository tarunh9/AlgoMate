package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Bubble extends AppCompatActivity {
    TextView t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble);
        Intent in = getIntent();
        String select = in.getStringExtra("select_key");
        LinearLayout vertical = (LinearLayout) findViewById(R.id.myVertical);

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
        //params.setMargins(60, 20, 10, 20);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        final TextView qTextView = new TextView(this);
        qTextView.setText("Question :" + inp + "\n");
        qTextView.setTextSize(25);
        qTextView.setLayoutParams(params);
        vertical.addView(qTextView);
        final TextView ansTextView = new TextView(this);
        ansTextView.setText("Answer :" +"\n");
        ansTextView.setTextSize(25);
        ansTextView.setLayoutParams(params);
        vertical.addView(ansTextView);
        int n = arr.length;
        int lines = -1;
        for (int i = 0; i < n - 1; i++) {    //System.out.println("Iteration:"+(i+1));
            output1 = "";
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                for (int k = 0; k < n; k++)
                    output1 += arr[k] + "   ";
                lines += 1;
                output1 += "\n";
            }
            //for (int k = 0; k < n; k++)
            //  output1 += arr[k] + " ";

            //output1+="\n";
            /////////////////////////
            //}
            //for (int z = 0; z < lines; z++)
            {
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

}
