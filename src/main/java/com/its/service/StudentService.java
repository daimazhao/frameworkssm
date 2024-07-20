package com.its.service;

import com.its.entity.Student;

import java.util.List;


    //service接口
public interface StudentService {
    List<Student> list(String name,String sex);

    int save(Student student);

    int deleteStudent(int id);

    Student queryStudentById(int id);

    int updateStudent(Student student);

    int batchDeleteStudents(String ids);

    }
