package com.code.model.oneToOne;

import org.apache.ibatis.type.Alias;

/**
 * 用户认证卡。
 * 与用户是一对一关系。
 */
@Alias("studentCard")
public class StudentCardDomain {

    private String id;
    private String cardNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
