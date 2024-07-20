package com.its.service.impl;


import com.its.entity.Student;
import com.its.mapper.StudentMapper;
import com.its.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired                              //对service接口的实现

    private StudentMapper studentMapper;     //实例化mapper对象从而关系
                                            //此处-->mapper-->mapper.xml-->mysql
                                            //此处上家是？  controller
                                            // 如何关系？   被实例化

    @Override
    //返回了sql数据
    public List<Student> list(String name,String sex){
        return studentMapper.list(name,sex);
    }

    @Override
    public int save(Student student){
        return studentMapper.save(student);
    }

    @Override
    public int deleteStudent(int id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public Student queryStudentById(int id) {
        return studentMapper.queryStudentById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int batchDeleteStudents(String ids){ return studentMapper.batchDeleteStudents(ids);}
}
