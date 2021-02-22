package com.tianjian.factory.core.data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tianjian on 2021/2/8.
 */
@Entity
public class UserInfoEo {

    //用户编码
    @Id
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
}
