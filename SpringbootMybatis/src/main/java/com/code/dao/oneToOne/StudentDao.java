package com.code.dao.oneToOne;

import com.code.model.oneToOne.StudentDomain;

import java.util.List;

/**
 * Created by Administrator on 2018/8/7.
 */
public interface StudentDao {

    int insert(StudentDomain student);

    List<StudentDomain> selectStudents();

    StudentDomain selectStudentByName(String name);
}
