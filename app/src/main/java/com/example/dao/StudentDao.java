package com.example.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * from student_table")
    LiveData<List<Student>> queryAllStudent();

    @Query("SELECT * from student_table where name like :queryName")
    LiveData<List<Student>> queryNameLikeStudentAsync(String queryName);

    @Query("SELECT * from student_table where name like :queryName")
    List<Student> queryNameLikeStudentSync(String queryName);

    @Insert()
    void insert(Student student);
}
