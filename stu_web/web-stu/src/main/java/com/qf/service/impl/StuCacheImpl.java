package com.qf.service.impl;

import com.qf.dao.StuMapper;
import com.qf.entity.Student;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@CacheConfig(cacheNames = "stu")
public class StuCacheImpl implements IStudentService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    @Cacheable(key = "'stuone'+ #id")
    public Student queryStuById(Integer id) {
        System.out.println("查询了单个对象");
        return stuMapper.selectById(id);
    }

    @Override
    @Cacheable(key = "'stulist'")
    public List<Student> queryStuList() {
        System.out.println("查询了数据库");
        return stuMapper.selectList(null);
    }

    @Override
    @CacheEvict(key = "'stulist'")
    public int update(Student student) {
        return stuMapper.updateById(student);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(key = "'stulist'"),
            @CacheEvict(key = "'stuone'+#id")
    })
    public int deleteById(Integer id) {
        return stuMapper.deleteById(id);
    }

    @Override
    @CachePut(key = "'stuone'+#result.id")
    @CacheEvict(key = "'stulist'")
    public Student insert(Student student) {
        stuMapper.insert(student);
        return student;
    }
}
