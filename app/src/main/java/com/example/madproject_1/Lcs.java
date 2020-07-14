package com.example.madproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lcs extends AppCompatActivity {
    EditText edit1, edit2;
    Button btn;
    TextView text1, text2,sq1,sq2;
    String x, y;
    int m, n;
    String st1="\n\n\n",st2="\n\t\t\t\t\t\t\t\t";
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lcs);
        edit1 = findViewById(R.id.firstString);
        edit2 = findViewById(R.id.secondString);
        btn = findViewById(R.id.lcsSubmit);
        text1 = findViewById(R.id.printLCS);
        text2 = findViewById(R.id.tableLCS);
        sq1 = findViewById(R.id.seq1);
        sq2 = findViewById(R.id.seq2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = edit1.getText().toString().toUpperCase();
                y = edit2.getText().toString().toUpperCase();
                m = x.length();
                n = y.length();
                text1.setText("");
                text2.setText("");
                sq1.setText("");
                sq2.setText("");
                st1="\n\n\n";
                st2="\n\t\t\t\t\t\t\t\t";
                char[] s1;
                char[] s2;
                s1=x.toCharArray();
                s2=y.toCharArray();
                for(char c:s1)
                    st1+=c+"\n";
                for(char i:s2)
                    st2+=i+"     ";
                int[][] L = new int[m + 1][n + 1];

                for (int i = 0; i <= m; i++) {
                    for (int j = 0; j <= n; j++) {
                        if (i == 0 || j == 0)
                            L[i][j] = 0;
                        else if (x.charAt(i - 1) == y.charAt(j - 1))
                            L[i][j] = L[i - 1][j - 1] + 1;
                        else
                            L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                    }
                }

                int index = L[m][n];
                int temp = index;
                String lcs1 = "LCS:";
                char[] lcs = new char[index + 1];
                lcs[index] = ' ';
                int i = m, j = n;
                while (i > 0 && j > 0) {
                    if (x.charAt(i - 1) == y.charAt(j - 1)) {
                        lcs[index - 1] = x.charAt(i - 1);
                        lcs1 += x.charAt(i - 1);
                        i--;
                        j--;
                        index--;
                    } else if (L[i - 1][j] > L[i][j - 1])
                        i--;
                    else
                        j--;
                }
                String res = "LCS: ";
                for (int k = 0; k <= temp; k++)
                    res += lcs[k];
                text1.setText(res);
                String res1 = "\n\n";
                for (int a = 0; a <= m; a++) {
                    for (int b = 0; b <= n; b++) {
                        res1 += "     " + L[a][b];
                    }
                    res1 += "\n";
                }
                text2.setText(res1);
                text2.setTextSize(20);
                text1.setTextSize(20);
                sq1.setText(st1);
                sq1.setTextSize(20);
                sq2.setText(st2);
                sq2.setTextSize(20);

            }
        });
    }
}