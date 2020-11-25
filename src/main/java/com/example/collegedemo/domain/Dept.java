package com.example.collegedemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Dept {
    @Id
    @Column
    private int deptid;

    @Column
    private String name;

    public Dept() {
    }

    public Dept(int deptid, String name) {
        this.deptid = deptid;
        this.name = name;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptid=" + deptid +
                ", name='" + name + '\'' +
                '}';
    }
}
