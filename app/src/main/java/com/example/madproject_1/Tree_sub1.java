package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Tree_sub1 extends AppCompatActivity {
    String lis;
    int size;
    String[] str;
    BinaryTreeView treeView = null;
    EditText e1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_sub1);
        LinearLayout layout = findViewById(R.id.mainLayout);
        //TextView textView = findViewById(R.id.messageView);
        btn = findViewById(R.id.button);
        e1=findViewById(R.id.edit);

        treeView = new BinaryTreeView(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lis = e1.getText().toString();
                str = lis.split(" ");
                size = str.length;
                Log.v("string", String.valueOf(str));
                ArrayList<Integer> numbers = new ArrayList<>(size);
                for (int i = 0; i < size; i++)
                    numbers.add(Integer.parseInt(str[i]));
                treeView.initialize(numbers);
            }
        });
        treeView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layout.addView(treeView);
    }

//    public boolean onPressStart(View view) {
//        treeView.initialize(lis);
//        return true;
//    }

}



