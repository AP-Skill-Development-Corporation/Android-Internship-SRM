package com.example.asynctasktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.userinput);
        tv = findViewById(R.id.textview);
    }

    public void search(View view) {
        String bookname = et.getText().toString();
        MyTask task = new MyTask(this,bookname,tv);
        task.execute();

    }
}
