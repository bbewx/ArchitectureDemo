package com.code.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * "@Alias"注解为该对象设置了一个别名，在mybatis的.xml配置文件中使用该对象时，可直接用别名，降低
 * 配置复杂度。例如：
 * <select id="selectUsers" resultType="user">
        SELECT
        <include refid="BASE_COLUMN"/>
        FROM
        <include refid="BASE_TABLE"/>
   </select>
 *
 *
 */
@Alias("user")
public class UserDomain implements Serializable {

    private Integer userId;

    private String userName;

    private String password;

    private String phone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
