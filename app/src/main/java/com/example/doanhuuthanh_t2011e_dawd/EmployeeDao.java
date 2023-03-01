package com.example.doanhuuthanh_t2011e_dawd;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert
    long insertEmp(Employee employee);

    @Update
    int updateEmp(Employee employee);

    @Delete
    int deleteEmp(Employee employee);

    @Query("Select * from employee where id = :id")
    Employee findEmp(int id);

    @Query("Select * from employee")
    List<Employee> getAllEmp();
}
