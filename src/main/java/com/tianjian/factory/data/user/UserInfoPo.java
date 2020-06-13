package com.tianjian.factory.data.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfoPo {

    /**
     * 用户id
     */
    @Id
    private String id;

    /**
     * 用户名称
     */
    private String userName;


    /**
     * 用户密码
     */
    private String passWord;

    /**
     * 用户手机号
     */
    private String telPhoneNum;


    /**
     * 用户角色
     */
    private String role;


    /**
     * 部门
     */
    private String departMentName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTelPhoneNum() {
        return telPhoneNum;
    }

    public void setTelPhoneNum(String telPhoneNum) {
        this.telPhoneNum = telPhoneNum;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartMentName() {
        return departMentName;
    }

    public void setDepartMentName(String departMentName) {
        this.departMentName = departMentName;
    }
}
