package com.example.collegedemo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Student {
    @Id
    private int studentid;
    @Column
    private String name;
    @Column
    private int rollno;
    @Column
    private String mobile;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dob;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_addressid", referencedColumnName = "addressid")
    private Address address;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "course", referencedColumnName = "courseid")
//    private Course course;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "dept", referencedColumnName = "deptid")
//    private Dept dept;


    public Student() {
    }

    public Student(int studentid, String name, int rollno, String mobile, Date dob, Address address) {
        this.studentid = studentid;
        this.name = name;
        this.rollno = rollno;
        this.mobile = mobile;
        this.dob = dob;
        this.address = address;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid='" + studentid + '\'' +
                ", name='" + name + '\'' +
                ", rollno=" + rollno +
                ", mobile=" + mobile +
                ", dob=" + dob +
                ", address=" + address +
                '}';
    }
}
