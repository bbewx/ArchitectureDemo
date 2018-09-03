package com.code.dao.oneToOne;

import com.code.model.oneToOne.StudentCardDomain;

/**
 * Created by Administrator on 2018/8/7.
 */
public interface StudentCardDao {

    int insert(StudentCardDomain studentCard);

    StudentCardDomain getStudentCardById(String id);
}
