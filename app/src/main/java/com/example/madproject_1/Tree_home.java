package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Tree_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_home);

        Button tree_bst = findViewById(R.id.button_bst);
        tree_bst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in22 = new Intent(Tree_home.this,Tree_sub1.class);
                startActivity(in22);
            }
        });

        Button tree_binary = findViewById(R.id.button_bt);
        tree_binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in23 = new Intent(Tree_home.this,Tree_binary.class);
                startActivity(in23);
            }
        });
    }
}
