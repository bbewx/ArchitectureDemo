package com.code.service;

import com.code.model.oneToOne.StudentCardDomain;
import com.code.model.oneToOne.StudentDomain;

import java.util.List;

/**
 * Created by Administrator on 2018/8/7.
 */
public interface StudentService {

    int addStudent(StudentDomain student);

    int addStudentCard(StudentCardDomain studentCard);

    List<StudentDomain> findStudents();

    StudentDomain findStudent(String name);
}
