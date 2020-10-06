package com.fudan.management.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManagementImpl implements Management {

    Map<Long, Student> studentMap = new HashMap<>();

    @Override
    public boolean addStudent(long studentId, String name, String department, String major) {
        if(studentMap.containsKey(studentId)) {
            return false;
        }
        else {
            Student student = new Student(studentId, name, department, major);
            studentMap.put(studentId, student);
            return true;
        }
    }

    @Override
    public List<Student> showStudents() {
        List<Student> students = new ArrayList<>();
        for(Map.Entry<Long, Student> student : studentMap.entrySet()) {
            students.add(student.getValue());
        }
        students.sort((s1, s2) -> {
            return (int) (s1.getStudentId() - s2.getStudentId());
        });
        return students;
    }

    @Override
    public boolean changeStudent(long studentId, String name, String department, String major) {
        if(!studentMap.containsKey(studentId)) {
            return false;
        }
        else {
            Student student = studentMap.get(studentId);
            student.setName(name);
            student.setDepartment(department);
            student.setMajor(major);
            studentMap.put(studentId, student);
            return true;
        }
    }

    @Override
    public boolean deleteStudent(long studentId) {
        if(!studentMap.containsKey(studentId)) {
            return false;
        }
        else {
            studentMap.remove(studentId);
            return true;
        }
    }
}
