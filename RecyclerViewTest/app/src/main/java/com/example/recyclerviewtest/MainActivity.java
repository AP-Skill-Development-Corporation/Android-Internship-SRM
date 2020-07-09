package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycler);

        int images[] = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
        R.drawable.e,R.drawable.fidha,R.drawable.g,R.drawable.h,R.drawable.i,
        R.drawable.j};

        String names[] = {"AA","Bahubali","Chirutha","Dookudu","Eega","fidha",
        "GabbarSingh","Happy","I Manoharudu","Jayam"};

        rv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(this,images,names);
        rv.setAdapter(adapter);



    }
}
