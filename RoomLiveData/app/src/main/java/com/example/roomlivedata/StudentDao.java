package com.example.roomlivedata;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    public void insert(Student student);

    @Query("SELECT * FROM StudentData")
    public List<Student> readData();

    @Delete
    public void delete(Student student);
}
