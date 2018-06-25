/*
 * 创建 WJL 2017-03-12 17:21
 */
package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * 。
 * <p>
 */
public class User {
    private String name;
    private String password;

    public User() {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @NotEmpty(message = "姓名不能为空")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 1, max = 8, message = "密码长度应在1~8之间")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
