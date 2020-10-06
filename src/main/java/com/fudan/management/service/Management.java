package com.fudan.management.service;

import java.util.Collection;

public interface Management {
    boolean addStudent(long studentId, String name, String department, String major);
    Collection<Student> showStudents();
    boolean changeStudent(long studentId, String name, String department, String major);
    boolean deleteStudent(long studentId);
}
