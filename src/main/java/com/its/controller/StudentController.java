package com.its.controller;

import com.its.entity.Student;
import com.its.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;      //service上家

    @RequestMapping("/list")
    public String list(Model model,String name,String sex){
        List<Student> list = studentService.list(name,sex);
        model.addAttribute("list",list);//将list数据传到了url“list”中
        return "student_list";
    }

    @RequestMapping("/save")
    public String save(Student student){
        int i = studentService.save(student);
        if (i>0){
            return "redirect:/student/list";
        }
        return "error";
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(int id){
        System.out.println("iddddd:"+id);
        int i = studentService.deleteStudent(id);
        if(i>0){
            return "redirect:/student/list";
        }
        return "error";
    }

    @RequestMapping("/queryStudentById")
    public String queryStudentById(int id,Model model) {
        Student student = studentService.queryStudentById(id);
        model.addAttribute("student",student);
        return "student_update";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Student student){
        int i = studentService.updateStudent(student);
        if (i>0){
            return "redirect:/student/list";
        }
        return "error";
    }

    @RequestMapping("/batchDeleteStudents")
    public String batchDeleteStudents(String ids){
        System.out.println("iddddd:"+ids);
        int i = studentService.batchDeleteStudents(ids);
        if(i>0){
            return "redirect:/student/list";
        }
        return "error";
    }

}
