package com.tianjian.factory.model.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UserInfoVo {

    @ApiModelProperty("用户编号")
    private String userId;

    /**
     * 微信id
     */
    @ApiModelProperty("openid")
    private String openid;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userCode;

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;


    /**
     * 用户密码
     */
    @ApiModelProperty("用户密码")
    private String passWord;

    /**
     * 用户手机号
     */
    @ApiModelProperty("用户手机号")
    private String telPhoneNum;


    /**
     * 用户角色
     */
    @ApiModelProperty("角色")
    private String role;

    /**
     * 用户token
     */
    @ApiModelProperty("用户token")
    private String token;


    /**
     * 部门
     */
    @ApiModelProperty("部门")
    private String departMentName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
