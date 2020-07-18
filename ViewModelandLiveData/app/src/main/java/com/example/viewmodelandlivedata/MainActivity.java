package com.example.viewmodelandlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private int count = 0;
    private TextView count_tv;
    MainViewModel mvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mvm = new ViewModelProvider(this).get(MainViewModel.class);
        Log.i("MainActivty","ViewModel is Initialized");

        count_tv = findViewById(R.id.count_textView); // Connecting the count_textView with count_tv TextView Instance
        //count_tv.setText(String.valueOf(mvm.count));
        mvm.count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                count_tv.setText(String.valueOf(integer));
            }
        });
    }

    /*The Following method, when invoked, increases the value on the
     * textview by 1.*/
    public void increment(View view)
    {
        mvm.doIncreament();
        //count_tv.setText(String.valueOf(mvm.count));
        //count++;                                // reducing the current value by 1
        //count_tv.setText(String.valueOf(count));// Setting the value of Count on the count textview on UI.
        // String.value() - converts the type of count value from Integer to String
    }

    /*The Following method, when invoked, decreases the value on the
     * textview by 1.*/
    public void decrement(View view)
    {
        mvm.doDecrement();
        //count_tv.setText(String.valueOf(mvm.count));
        //count--;                                 // reducing the current value by 1
        //count_tv.setText(String.valueOf(count)); // Setting the value of Count on the count textview on UI.
        // String.value() - converts the type of count value from Integer to String
    }
}
