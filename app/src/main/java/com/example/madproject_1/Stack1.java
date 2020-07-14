package com.example.madproject_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Stack;

public class Stack1 extends AppCompatActivity implements View.OnClickListener{
    Button push, pop;
    EditText data;
    TextView StackEntry;
    Stack<String> st = new Stack<>();
    String squeue="";
    String squeue1="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack1);
        push = findViewById(R.id.pushval);
        pop = findViewById(R.id.popval);
        data = findViewById(R.id.enternum);
        StackEntry = findViewById(R.id.stackEntry);
        push.setOnClickListener(this);
        pop.setOnClickListener(this);
    }

    public void showMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.pushval) {
            if (data.getText().toString().trim().length() != 0) {
                String s = data.getText().toString();
                st.push(s);
                //String res="Pushed "+ s +" into Stack";
                //showMessage(res);
                Iterator value = st.iterator();
                String rees="";
                squeue="";
                while (value.hasNext()) {
                    squeue += value.next()+"\n";
                }
                char[] try1 = squeue.toCharArray();
                for (int i = try1.length-1; i>=0; i--)
                    rees+=try1[i];
                StackEntry.setText(rees);
                data.setText("");
            }
            else {
                showMessage("Enter input!");
            }
        }
        if (v.getId() == R.id.popval) {
            if(!st.empty()){
                String res1 = st.pop();
                //String res= "Popped "+ res1 +" from Stack";
                //showMessage(res);
                String rees1="";
                squeue1="";
                Iterator value = st.iterator();
                while (value.hasNext()) {
                    squeue1 +=value.next()+"\n";
                }
                char[] try1 = squeue1.toCharArray();
                for (int i = try1.length-1; i>=0; i--)
                    rees1+=try1[i];
                StackEntry.setText(rees1);
            }
            else
                showMessage("Empty Stack!");
        }
    }
}