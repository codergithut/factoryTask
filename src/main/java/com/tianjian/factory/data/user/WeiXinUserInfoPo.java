package com.tianjian.factory.data.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WeiXinUserInfoPo {

    /**
     * 微信关联id
     */
    @Id
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 微信公众号id
     */
    private String openid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }


}
