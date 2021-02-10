package com.tianjian.factory.core.mysql;

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

}
