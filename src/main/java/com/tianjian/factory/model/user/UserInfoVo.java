package com.tianjian.factory.model.user;

import java.util.UUID;

public class UserInfoVo {

    /**
     * 微信id
     */
    private String openid;

    /**
     * 用户id
     */
    private String userCode;

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


    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public static UserInfoVo mockUsrInfoVo() {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setDepartMentName("develop");
        userInfoVo.setPassWord("tj");
        userInfoVo.setUserCode("e4511a57-e1bb-4cb7-b590-0be8a7ea8a01");
        userInfoVo.setOpenid("fd70aca2-efcf-4c1f-8027-3d91eb7bf64b");
        userInfoVo.setRole("boss");
        userInfoVo.setTelPhoneNum("12345973290");
        userInfoVo.setUserName("tianjian");
        return userInfoVo;
    }
}
