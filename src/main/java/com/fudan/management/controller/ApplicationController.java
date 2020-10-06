package com.fudan.management.controller;

import com.fudan.management.service.ManagementImpl;
import com.fudan.management.service.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ApplicationController {
    @Autowired
    ManagementImpl management;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/show")
    public String show() {
        return "show";
    }

    @GetMapping("/change")
    public String change() {
        return "change";
    }

    @GetMapping("/delete")
    public String delete() {
        return "delete";
    }

    @ResponseBody
    @PostMapping("/v1/student")
    public boolean addStudent(@RequestBody Student student) {
        long studentId = student.getStudentId();
        String name = student.getName();
        String department = student.getDepartment();
        String major = student.getMajor();
        return management.addStudent(studentId, name, department, major);
    }

    @ResponseBody
    @GetMapping("/v1/student")
    public List<Student> showClick() {
        return management.showStudents();
    }

    @ResponseBody
    @PutMapping("/v1/student")
    public boolean changeStudent(@RequestBody Student student) {
        long studentId = student.getStudentId();
        String name = student.getName();
        String department = student.getDepartment();
        String major = student.getMajor();
        return management.changeStudent(studentId, name, department, major);
    }

    @ResponseBody
    @DeleteMapping("/v1/student")
    public boolean deleteStudent(@RequestBody Student student) {
        long studentId = student.getStudentId();
        return management.deleteStudent(studentId);
    }
}
