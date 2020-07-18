package com.example.viewmodelandlivedata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    //int count = 0;

    MutableLiveData<Integer> count = new MutableLiveData<>();


    public MainViewModel() {
        Log.i("MainViewModel","ViewModel is Created");
        count.setValue(0);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("MainViewModel","ViewModel is Destroyed");
    }

    public void doIncreament(){
        //count++;
        count.setValue(count.getValue()+1);
    }

    public void doDecrement(){
       // count--;
        count.setValue(count.getValue()-1);
    }

}
