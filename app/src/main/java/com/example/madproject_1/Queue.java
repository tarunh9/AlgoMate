package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Stack;
import android.os.Bundle;

public class Queue extends AppCompatActivity implements View.OnClickListener{
    Button enqueue, dequeue;
    EditText Queuedata;
    TextView QueueEntry;
    String squeue="";
    String squeue1="";
    Stack<String> q = new Stack<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);
        enqueue = findViewById(R.id.enqueueval);
        dequeue = findViewById(R.id.dequeueval);
        Queuedata = findViewById(R.id.enternumQ);
        QueueEntry = findViewById(R.id.queueEntry);
        enqueue.setOnClickListener(this);
        dequeue.setOnClickListener(this);
    }
    public void showMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.show();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.enqueueval) {
            if (Queuedata.getText().toString().trim().length() != 0) {
                String s = Queuedata.getText().toString();
                q.push(s);
                String res="Enqueued "+s+" into Queue";
                //showMessage(res);
                Iterator value = q.iterator();
                squeue="";
                while (value.hasNext()) {
                    squeue += " " + value.next();
                }
                QueueEntry.setText(squeue);

            }
            else {
                showMessage("Enter Input !");
            }
        }
        if (v.getId() == R.id.dequeueval) {
            if(!q.isEmpty()){
                QueueEntry.setText("");
                String res1 = q.remove(0);
                String res= "Dequeue "+res1+" from Queue";
                //showMessage(res);
                Iterator value = q.iterator();
                squeue1="";
                while (value.hasNext()) {
                    squeue1 += " " + value.next();
                }
                QueueEntry.setText(squeue1);
            }
            else{
                showMessage("Empty Queue !");
            }

        }

    }
}
