package com.example.collegedemo.service;

import com.example.collegedemo.domain.Student;
import com.example.collegedemo.domain.StudentDto;
import com.example.collegedemo.exception.NoDataFoundException;
import com.example.collegedemo.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public Student saveStudent(Student student);
    public StudentDto saveAllStudent(List<Student> student) throws NoDataFoundException;
    public List<Student> getAllStudents() throws NoDataFoundException;
    public Student deleteStudent(int id) throws StudentNotFoundException;
    public List<Student> deleteAllStudent(int[] id) throws StudentNotFoundException;
    public Student updateStudent(Student student) throws StudentNotFoundException;
    public Student getStudent(int id);
}
