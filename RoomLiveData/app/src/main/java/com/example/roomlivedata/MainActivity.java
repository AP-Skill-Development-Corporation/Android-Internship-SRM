package com.example.roomlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static StudentDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        database = Room.databaseBuilder(this,StudentDatabase.class,"MYDB")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();


        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,InsertActivity.class));
            }
        });

        List<Student> studentList = database.myDao().readData();

        for (int i = 0; i<studentList.size(); i++){
            Toast.makeText(this, ""+i, Toast.LENGTH_SHORT).show();

            Toast.makeText(this, ""+studentList.get(i).getRollNubmer(), Toast.LENGTH_SHORT).show();

        }

    }
}