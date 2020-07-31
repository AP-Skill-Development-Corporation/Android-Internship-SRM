package com.example.registerandloginmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_email,et_user,et_pass;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.name);
        et_email = findViewById(R.id.emailid);
        et_user = findViewById(R.id.username);
        et_pass = findViewById(R.id.password);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

    }

    public void register(View view) {
        String name = et_name.getText().toString();
        String email = et_email.getText().toString();
        String username = et_user.getText().toString();
        String pass = et_pass.getText().toString();
        User u = new User(name,email,username,pass);
        reference.child("Users").push().setValue(u).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this,
                        "Registration Success", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openloginPage(View view) {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}
