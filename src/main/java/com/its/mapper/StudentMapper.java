package com.its.mapper;

import com.its.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

    //mapper接口对接resource
@Mapper
public interface StudentMapper {
    //多个参数无法分别，加入@Param
    List<Student> list(@Param("name") String name,@Param("sex") String sex);

    int save(Student student);

    int deleteStudent(int id);

    Student queryStudentById(int id);

    int updateStudent(Student student);

    int batchDeleteStudents(String ids);

}
