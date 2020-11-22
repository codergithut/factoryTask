package com.tianjian.factory.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by tianjian on 2020/4/12.
 */
@ApiModel
public class WeiXinLogin {

    @ApiModelProperty("sessionKey")
    private String session_key;

    @ApiModelProperty("微信openid")
    private String openid;

    @ApiModelProperty("微信unionId")
    private String unionId;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
