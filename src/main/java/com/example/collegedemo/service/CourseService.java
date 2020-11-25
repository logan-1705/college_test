package com.example.collegedemo.service;

import com.example.collegedemo.domain.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public Course saveCourse(Course course);
    public List<Course> saveAllCourse(List<Course> courseList);
    public Course getCourse(int id);
    public List<Course> getAllCourse();
}
