package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tree_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_main);
        Button bt=(Button)findViewById(R.id.btree);
        final EditText et=(EditText)findViewById(R.id.input);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inp=et.getText().toString();
                Intent i=new Intent(Tree_main.this,Tree_sub.class);
                i.putExtra("input",inp);
                startActivity(i);
            }
        });
    }
}
