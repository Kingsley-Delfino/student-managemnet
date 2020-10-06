package com.fudan.management.service;
public class Student {
    private final long studentId;
    private String name;
    private String department;
    private String major;

    Student(long studentId, String name, String department, String major){
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.major = major;
    }

    public long getStudentId() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public String getDepartment() {
        return department;
    }

    public String getMajor() {
        return major;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
