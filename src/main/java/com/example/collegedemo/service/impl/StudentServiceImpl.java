package com.example.collegedemo.service.impl;

import com.example.collegedemo.domain.Student;
import com.example.collegedemo.domain.StudentDto;
import com.example.collegedemo.exception.NoDataFoundException;
import com.example.collegedemo.exception.StudentNotFoundException;
import com.example.collegedemo.repositiory.StudentRepository;
import com.example.collegedemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
//        Optional<Student> isStudentExist = studentRepository.findById(student.getStudentid());
//        if (!isStudentExist.isPresent())
//            throw new StudentAlreadyExistsException("Student with this id already present!!!");

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) throws StudentNotFoundException {
        Optional<Student> isStudentPresent = studentRepository.findById((student.getStudentid()));
        System.out.println(isStudentPresent);
        if (isStudentPresent.get().getStudentid() == student.getStudentid()) {
            return studentRepository.save(student);
        }
//        else if(!isStudentPresent.isPresent())
        throw new StudentNotFoundException("requested Student does not exist");
    }

    @Override
    public StudentDto saveAllStudent(List<Student> student) throws NoDataFoundException {
        if (student.isEmpty())
            throw new NoDataFoundException("Must have One or more student objects");
        List<Student> alreadyExist = new ArrayList<Student>();

        for (Student st : student) {
            Optional<Student> returnStudent = studentRepository.findById(st.getStudentid());
            if (returnStudent.isPresent() && returnStudent.get().getStudentid() != 0) {
                alreadyExist.add(st);
            }
        }

        if (alreadyExist.size() > 0)
            student.removeAll(alreadyExist);

        List<Student> response = (List<Student>) studentRepository.saveAll(student);
        return new StudentDto(response,
                new Error("IDs Already Exists: " +
                        alreadyExist
                                .stream()
                                .map(Student::getStudentid)
                                .collect(Collectors.toList())));

    }

    @Override
    public List<Student> getAllStudents() throws NoDataFoundException {
        if ((studentRepository.findAll().isEmpty())) {
            throw new NoDataFoundException("No Data  Found  ");
        }
        return studentRepository.findAll();
    }

    @Override
    public Student deleteStudent(int id) throws StudentNotFoundException {
        Student st = studentRepository.findById(id).orElse(null);
        if (st == null)
            throw new StudentNotFoundException("Student Id does not exist...!!");

        studentRepository.deleteById(id);
        return st;
    }


    @Override
    public List<Student> deleteAllStudent(int[] id) throws StudentNotFoundException {
        Student st;
        List<Student> deletedIds = new ArrayList<Student>();

        for (int i = 0; i < id.length; i++) {
            int deleteId = id[i];
            st = studentRepository.findById(deleteId).orElse(null);
            if (st == null)
                throw new StudentNotFoundException("Student Id does not exist...!!");

            deletedIds.add(st);
            studentRepository.deleteById(deleteId);

        }

        return deletedIds;
    }


    @Override
    public Student getStudent(int id) {
        Optional ops = studentRepository.findById(id);
        System.out.println(ops);
        if (ops.isPresent())
            return (Student) ops.get();
        return new Student();
    }
}
