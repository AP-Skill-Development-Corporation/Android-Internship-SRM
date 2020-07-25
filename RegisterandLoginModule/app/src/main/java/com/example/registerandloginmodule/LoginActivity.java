package com.example.registerandloginmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText et_user,et_pass;
    DatabaseReference reference;
    List<User> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_user = findViewById(R.id.login_username);
        et_pass = findViewById(R.id.login_password);
        reference = FirebaseDatabase.getInstance().getReference();
        list = new ArrayList<>();
        reference.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    User u = dataSnapshot.getValue(User.class);
                    list.add(u);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void login(View view) {
        final String user = et_user.getText().toString();
        final String pass = et_pass.getText().toString();
       for(int i = 0;i<list.size();i++){
           if((user.equals(list.get(i).getUsername())) && (pass.equals(list.get(i).getPass())) ){
               Toast.makeText(this,
                       "Success", Toast.LENGTH_SHORT).show();
               Log.i("Data",list.get(i).getUsername());
               Log.i("Data",list.get(i).getPass());
               Intent intent = new Intent(LoginActivity.this,WelcomeActivity.class);
               startActivity(intent);
               break;
           }else{
               Toast.makeText(this,
                       "Failed", Toast.LENGTH_SHORT).show();

           }
       }


    }
}
