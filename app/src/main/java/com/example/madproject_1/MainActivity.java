package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Spinner s;
    String a,select,len;
    String d[] = {"Bubble Sort", "Insertion Sort","Selection Sort"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = (Spinner)findViewById(R.id.select);

        final ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,R.layout.my_spinner_format,d);
        adapter.setDropDownViewResource(R.layout.my_spinner_format);
        s.setAdapter(adapter);

        final EditText txtEnter=(EditText)findViewById(R.id.enter);

        Button btnSubmit=(Button)findViewById(R.id.submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = s.getSelectedItem().toString();
                if(text=="Bubble Sort"){
                    Intent i=new Intent(MainActivity.this,Bubble.class);

                    a= txtEnter.getText().toString();
                    select=s.getSelectedItem().toString();

                    i.putExtra("array_key",a);
                    i.putExtra("select_key",select);

                    startActivity(i);
                }
                else if (text=="Insertion Sort"){
                    Intent j=new Intent(MainActivity.this,Insertion_sort.class);

                    a= txtEnter.getText().toString();
                    select=s.getSelectedItem().toString();

                    j.putExtra("array_key",a);
                    j.putExtra("select_key",select);

                    startActivity(j);

                }
                else if (text=="Selection Sort"){
                    Intent j=new Intent(MainActivity.this,Selection.class);

                    a= txtEnter.getText().toString();
                    select=s.getSelectedItem().toString();

                    j.putExtra("array_key",a);
                    j.putExtra("select_key",select);

                    startActivity(j);

                }
            }
        });
    }

}
