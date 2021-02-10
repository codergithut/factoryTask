package com.tianjian.factory.core.model;

import java.util.UUID;

/**
 * Created by tianjian on 2021/2/8.
 */
public class UserInfoDTO {

    //用户编码
    private String userCode;

    //手机号码
    private String telePhone;

    //部门编码
    private String departMentCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getDepartMentCode() {
        return departMentCode;
    }

    public void setDepartMentCode(String departMentCode) {
        this.departMentCode = departMentCode;
    }

    public static UserInfoDTO mockData() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserCode(UUID.randomUUID().toString());
        userInfoDTO.setDepartMentCode("开发");
        userInfoDTO.setTelePhone("13029819012");
        return userInfoDTO;
    }
}
