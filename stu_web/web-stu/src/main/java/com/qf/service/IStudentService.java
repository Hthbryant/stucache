package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

public interface IStudentService {

    Student queryStuById(Integer id);

    List<Student> queryStuList();

    int update(Student student);

    int deleteById(Integer id);

    Student insert(Student student);
}
