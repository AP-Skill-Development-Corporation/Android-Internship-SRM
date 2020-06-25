package com.example.countapp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView tv;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =findViewById(R.id.countInc);
        tv = findViewById(R.id.textcount);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action
                a++;
                tv.setText(""+a);

            }
        });

    }


    public void display(View view) {
        //Action
        Toast.makeText(this,"Welcome to SRM",Toast.LENGTH_SHORT).show();
    }
}
