package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Algo_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algo_home);

        Button sort1 = findViewById(R.id.button2);
        sort1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Algo_home.this,MainActivity.class);
                startActivity(i);
            }
        });

        Button ds = findViewById(R.id.button_top11);
        ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Algo_home.this,Home.class);
                startActivity(i2);
            }
        });

        Button lcs = findViewById(R.id.button3_lcs);
        lcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lcs_in = new Intent(Algo_home.this,Lcs.class);
                startActivity(lcs_in);
            }
        });

        Button prims = findViewById(R.id.button4_prims);
        prims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prims_i4 = new Intent(Algo_home.this,Prims_home.class);
                startActivity(prims_i4);
            }
        });
    }
}
