package com.example.roomlivedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    MyRepository repository;
    LiveData<List<Student>> getAllData;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
        getAllData = repository.readALLData();

    }

    /*This is for Insert Method*/
    public void insert(Student student){
        repository.insert(student);
    }

    /*This is for Update Method*/
    public void update(Student student){
        repository.update(student);
    }

    /*This is for delete method*/
    public void delete(Student student){
        repository.delete(student);
    }

    /*This is for read Data method*/
    public LiveData<List<Student>> readData(){
        return getAllData;
    }

}

