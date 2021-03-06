package com.tianjian.factory.data.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserInfoDataCurd extends CrudRepository<UserInfoPo,String> {
    List<UserInfoPo> findByDepartMentName(String departMentName);

    UserInfoPo findByUserName(String userName);

    UserInfoPo findByUserNameAndPassWord(String userName, String passWord);

    UserInfoPo findByTelPhoneNumAndPassWord(String telPhoneNum, String passWord);
}
