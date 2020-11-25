package com.example.collegedemo.domain;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Course {
    @Id
    private int courseid;
    @Column
    private String name;

    public Course() {
    }

    public Course(int courseid, String name) {
        this.courseid = courseid;
        this.name = name;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", name='" + name + '\'' +
                '}';
    }
}
