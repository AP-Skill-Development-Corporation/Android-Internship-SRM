package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textstate);
        tv.append("onCreate() \n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        tv.append("onStart() \n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.append("onResume() \n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv.append("onRestart() \n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv.append("onDestroy() \n");
        Toast.makeText(this, "onDestory()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        tv.append("onPause() \n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        tv.append("onStop() \n");
    }
}
