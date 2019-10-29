package com.qf.controller;

import com.qf.entity.Student;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController {


    @Autowired
    private IStudentService studentService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/stuList")
    public String stuList(ModelMap map){

        /*List<Student> studentList = (List<Student>) redisTemplate.opsForValue().get("stulist");
        if(studentList==null){
            System.out.println("通过数据库查询了学生列表");
            studentList = studentService.queryStuList();
            redisTemplate.opsForValue().set("stulist",studentList);
        }*/
        List<Student> studentList = studentService.queryStuList();
        map.put("stuList",studentList);

        return "stuList";
    }
    @RequestMapping("/update")
    public String update(Integer id){

        Student student = studentService.queryStuById(id);
        student.setName(student.getName()+"1");
        studentService.update(student);

        return "redirect:/stu/stuList";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        int result = studentService.deleteById(id);

        return "redirect:/stu/stuList";
    }

    @RequestMapping("/insert")
    public String insert(){
        Student student = new Student();
        student.setName("xiaoming").setAge(10).setCid(3);
        Student student1 = studentService.insert(student);

        return "redirect:/stu/stuList";
    }
    @RequestMapping("/queryById")
    public String queryById(Integer id,ModelMap map){

       /* Student student2 = (Student) redisTemplate.opsForValue().get("stuone"+id);
        if (student2==null){
            System.out.println("通过id查询了学生对象");
            student2 = studentService.queryStuById(id);
            redisTemplate.opsForValue().set("stuone"+id,student2);
        }*/
        Student student2 = studentService.queryStuById(id);
        map.put("student",student2);

        return "stuInfo";
    }

}
