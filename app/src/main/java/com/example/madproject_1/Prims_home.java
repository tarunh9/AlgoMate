package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Prims_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prims_home);
        Button btn=(Button)findViewById(R.id.submit_prims);
        final EditText adjmat=(EditText)findViewById(R.id.adjmat);
        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String input = adjmat.getText().toString();
                Intent i = new Intent(Prims_home.this, Prims_sub1.class);
                i.putExtra("input", input);
                startActivity(i);
            }
        });
    }
}