package com.tianjian.factory.data.user;

import org.springframework.data.repository.CrudRepository;

public interface WeiXinUserInfoCurd extends CrudRepository<WeiXinUserInfoPo,String> {
    WeiXinUserInfoPo findByOpenid(String openid);
}
