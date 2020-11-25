package com.example.collegedemo.controller;

import com.example.collegedemo.domain.Student;
import com.example.collegedemo.domain.StudentDto;
import com.example.collegedemo.exception.NoDataFoundException;
import com.example.collegedemo.exception.StudentNotFoundException;
import com.example.collegedemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        ResponseEntity<?> responseEntity;
        try{
            Student savedStudent = studentService.saveStudent(student);
            responseEntity = new ResponseEntity<Student>(savedStudent, HttpStatus.OK);
        }catch (Exception ex){
            responseEntity = new ResponseEntity<String>("{ \"message\": \"" + ex.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id){
        ResponseEntity<?> responseEntity;
        try{
            Student savedStudent = studentService.getStudent(id);
            responseEntity = new ResponseEntity<Student>(savedStudent, HttpStatus.OK);
        }catch (Exception ex){
            responseEntity = new ResponseEntity<String>("{\"message\": \"" + ex.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @PostMapping("/saveall")
    public ResponseEntity<?> saveAllStudent(@RequestBody List<Student> students) {
//        List<Student> st = studentService.saveAllStudent(student);
        ResponseEntity responseEntity;
        try {
            StudentDto studentDto = studentService.saveAllStudent(students);
            responseEntity = new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
        } catch (NoDataFoundException ndfe) {
            responseEntity = new ResponseEntity<String>("{ \"message\": \"" + ndfe.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAllStudent() {
        ResponseEntity<?> responseEntity;
        try {
            List<Student> student = studentService.getAllStudents();
            responseEntity = new ResponseEntity<>(student, HttpStatus.OK);
        } catch (NoDataFoundException e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
        // return studentService.getAllSt
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        ResponseEntity responseEntity;
        try {
            Student st;
            st = studentService.deleteStudent(id);
            responseEntity = new ResponseEntity<String>("{  \"Deleted\": \"" + (st) + "\"}", HttpStatus.OK);
        } catch (Exception | StudentNotFoundException e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);


        }
        return responseEntity;
    }
    @DeleteMapping("/deleteallstudent/[id]")
    public ResponseEntity<?> deleteAllStudent(int[] id) {
        List<Student> st;
        ResponseEntity responseEntity;
        try {

            st = studentService.deleteAllStudent(id);
            responseEntity = new ResponseEntity<String>("{  \"Deleted\": \"" + (st) + "\"}", HttpStatus.OK);
        } catch (Exception | StudentNotFoundException e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);


        }
        return responseEntity;
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        ResponseEntity<?> responseEntity;
        try{
            Student updateStudent = studentService.saveStudent(student);
            responseEntity = new ResponseEntity<Student>(updateStudent, HttpStatus.OK);
        }catch (Exception ex){
            responseEntity = new ResponseEntity<String>("{ \"message\": \"" + ex.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}


