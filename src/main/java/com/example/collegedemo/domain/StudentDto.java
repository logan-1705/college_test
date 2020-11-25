package com.example.collegedemo.domain;

import java.util.List;

public class StudentDto  {
    List<Student> student;
    Error error;

    public StudentDto(List<Student> student, Error error) {
        this.student = student;
        this.error = error;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public StudentDto() {
    }
}
