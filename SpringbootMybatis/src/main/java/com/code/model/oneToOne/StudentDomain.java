package com.code.model.oneToOne;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 学生实体类。
 */
@Alias("student")
public class StudentDomain implements Serializable {

    private String            id;
    private String            stuName;
    private StudentCardDomain studentCard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public StudentCardDomain getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(StudentCardDomain studentCard) {
        this.studentCard = studentCard;
    }
}
