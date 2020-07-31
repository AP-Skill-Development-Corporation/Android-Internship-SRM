package com.example.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.value1);
        et2 = findViewById(R.id.value2);
        et3 = findViewById(R.id.value3);
        et4 = findViewById(R.id.value4);
        et5 = findViewById(R.id.value5);
    }

    public void bargraph(View view) {

        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();
        String s3 = et3.getText().toString();
        String s4 = et4.getText().toString();
        String s5 = et5.getText().toString();

        Intent i = new Intent(this,BarGraphActivity.class);
        i.putExtra("key1",s1);
        i.putExtra("key2",s2);
        i.putExtra("key3",s3);
        i.putExtra("key4",s4);
        i.putExtra("key5",s5);
        startActivity(i);

    }

    public void pichart(View view) {
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();
        String s3 = et3.getText().toString();
        String s4 = et4.getText().toString();
        String s5 = et5.getText().toString();

        Intent intent = new Intent(this,PieChartActiivty.class);
        intent.putExtra("key1",s1);
        intent.putExtra("key2",s2);
        intent.putExtra("key3",s3);
        intent.putExtra("key4",s4);
        intent.putExtra("key5",s5);
        startActivity(intent);
    }
}