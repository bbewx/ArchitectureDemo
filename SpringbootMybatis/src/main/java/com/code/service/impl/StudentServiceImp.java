package com.code.service.impl;

import com.code.dao.oneToOne.StudentCardDao;
import com.code.dao.oneToOne.StudentDao;
import com.code.model.oneToOne.StudentCardDomain;
import com.code.model.oneToOne.StudentDomain;
import com.code.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/8/7.
 */
@Service
@Transactional
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentCardDao studentCardDao;

    @Override
    public int addStudent(StudentDomain student) {
        studentCardDao.insert(student.getStudentCard());
        return studentDao.insert(student);
    }

    @Override
    public int addStudentCard(StudentCardDomain studentCard) {
        return studentCardDao.insert(studentCard);
    }

    @Override
    public List<StudentDomain> findStudents() {
        return studentDao.selectStudents();
    }

    @Override
    public StudentDomain findStudent(String name) {
        return studentDao.selectStudentByName(name);
    }
}
