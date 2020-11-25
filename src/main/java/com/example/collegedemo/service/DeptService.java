package com.example.collegedemo.service;

import com.example.collegedemo.domain.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {
    public Dept saveDepartment(Dept dept);
    public List<Dept> saveAllDept(List<Dept> dept);
    public Dept getDept(int id);
    public Dept updateDept(Dept dept);
    public List<Dept> getAllDepartments();
}
