package com.example.sharedprefrencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_u,et_p;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_u = findViewById(R.id.username);
        et_p = findViewById(R.id.password);
        preferences = getPreferences(MODE_PRIVATE);
        if(preferences!=null){
            String user = preferences.getString("username","Data not Fount");
            String pass = preferences.getString("password","Data not Fount");
            et_u.setText(user);
            et_p.setText(pass);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        String u = et_u.getText().toString();
        String p = et_p.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username",u);
        editor.putString("password",p);
        editor.apply();

    }
}
