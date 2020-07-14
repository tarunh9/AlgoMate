package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button stack1 = findViewById(R.id.button4);
        stack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent st = new Intent(Home.this,Stack1.class);
                startActivity(st);
            }
        });
        Button queue = findViewById(R.id.button3);
        queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent que = new Intent(Home.this,Queue.class);
                startActivity(que);
            }
        });
        Button algo_home = findViewById(R.id.button_top2);
        algo_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2 = new Intent(Home.this,Algo_home.class);
                startActivity(in2);
            }
        });
        Button tree_home = findViewById(R.id.button2);
        tree_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2 = new Intent(Home.this,Tree_home.class);
                startActivity(in2);
            }
        });
    }
}
