package com.example.myapp.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapp.entities.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM Student")
    List<Student> getAllStudents();

    @Query("SELECT * FROM Student WHERE id = :id")
    Student getStudentById(int id);

    @Query("SELECT * FROM Student WHERE email = :email AND password = :password")
    Student getStudentByEmailAndPassword(String email,String password);

    @Query("SELECT * FROM Student WHERE email = :email")
    Student getStudentByEmail(String email);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertStudent(Student student);

}
