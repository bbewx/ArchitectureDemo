package com.code.controller;

import com.code.model.oneToOne.StudentCardDomain;
import com.code.model.oneToOne.StudentDomain;
import com.code.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/8/7.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 实现学生和学生卡的一对一关联插入。
     */
    @ResponseBody
    @PostMapping(value = "/addStu")
    public int addStudent(@Param("name") String name, @Param("cardNum") String cardNum) {
        StudentDomain student = new StudentDomain();
        student.setStuName(name);
        StudentCardDomain card = new StudentCardDomain();
        card.setCardNum(cardNum);
        student.setStudentCard(card);
        return studentService.addStudent(student);
    }

    @ResponseBody
    @PostMapping(value = "/addCard")
    public int addStudentCard(StudentCardDomain studentCard) {
        return studentService.addStudentCard(studentCard);
    }

    /**
     * 实现学生和学生卡的一对一关联查询。
     */
    @ResponseBody
    @GetMapping(value = "/allStu")
    public List<StudentDomain> findStudents() {
        return studentService.findStudents();
    }

    /**
     * 实现学生和学生卡的一对一关联查询。
     */
    @ResponseBody
    @GetMapping(value = "/stu/{name}")
    public StudentDomain findStudent(@PathVariable("name") String name) {
        return studentService.findStudent(name);
    }
}
