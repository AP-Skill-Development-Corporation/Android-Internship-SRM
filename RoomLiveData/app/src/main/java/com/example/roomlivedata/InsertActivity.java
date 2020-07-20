package com.example.roomlivedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText rollnumber,uname,mailid,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        rollnumber =findViewById(R.id.rollnumber);
        uname = findViewById(R.id.name);
        mailid = findViewById(R.id.mailid);
        phone = findViewById(R.id.phonenumber);

    }

    public void save(View view) {
        String roll = rollnumber.getText().toString();
        String name = uname.getText().toString();
        String mail = mailid.getText().toString();
        String mobile = phone.getText().toString();

        Student student = new Student();
        student.setRollNubmer(roll);
        student.setName(name);
        student.setMailID(mail);
        student.setPhoneNumber(mobile);

        //MainActivity.database.myDao().insert(student);

        MainActivity.viewModel.insert(student);

        Toast.makeText(this, "Data Saved Sucessfully", Toast.LENGTH_SHORT).show();

        finish();
    }
}