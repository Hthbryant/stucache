package com.qf.service.impl;

import com.qf.dao.StuMapper;
import com.qf.entity.Student;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public Student queryStuById(Integer id) {
        return stuMapper.selectById(id);
    }

    @Override
    public List<Student> queryStuList() {
        return stuMapper.selectList(null);
    }

    @Override
    public int update(Student student) {
        return stuMapper.updateById(student);
    }

    @Override
    public int deleteById(Integer id) {
        return stuMapper.deleteById(id);
    }

    @Override
    public Student insert(Student student) {
        stuMapper.insert(student);
        return student;
    }
}
