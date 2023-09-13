package com.zhy.javaEnd.model;

/**
 * @author Lenovo
 * @version 1.0
 * @description TODO
 * @date 17/5/2023 下午6:38
 */

public class User {
    private Integer id;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userMail;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userMail='" + userMail + '\'' +
                '}';
    }

    public User(){}

    public User(Integer id, String userName, String userPassword, String userPhone, String userMail) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userMail = userMail;
    }

    public User(String userName, String userPassword, String userPhone, String userMail) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userMail = userMail;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }


}
