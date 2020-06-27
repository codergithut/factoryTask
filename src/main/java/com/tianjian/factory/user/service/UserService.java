package com.tianjian.factory.user.service;

import com.tianjian.factory.data.user.UserInfoDataCurd;
import com.tianjian.factory.data.user.UserInfoPo;
import com.tianjian.factory.data.user.WeiXinUserInfoCurd;
import com.tianjian.factory.data.user.WeiXinUserInfoPo;
import com.tianjian.factory.model.user.UserInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private WeiXinUserInfoCurd weiXinUserInfoCurd;

    @Autowired
    private UserInfoDataCurd userInfoDataCurd;

    /**
     * 获取用户信息
     * @param openId 微信登录id
     * @return
     */
    public UserInfoVo getUserInfoByOpenId(String openId) {
        WeiXinUserInfoPo weiXinUserInfoPo = weiXinUserInfoCurd.findByOpenid(openId);
        if(weiXinUserInfoPo != null) {
            Optional<UserInfoPo> userInfoPoOpt = userInfoDataCurd.findById(weiXinUserInfoPo.getUserId());
            if(!userInfoPoOpt.isPresent()) {
                return null;
            }
            UserInfoVo userInfo = new UserInfoVo();
            BeanUtils.copyProperties(userInfoPoOpt.get(), userInfo);
            userInfo.setUserId(userInfoPoOpt.get().getId());
            return userInfo;
        } else {
            return null;
        }
    }

    /**
     * 保持用户信息
     * @param userInfoVo
     * @return
     */
    public Boolean saveUserInfo(UserInfoVo userInfoVo) {
        //openId 已经注册无需注册
        if(getUserInfoByOpenId(userInfoVo.getOpenid()) != null) {
            return false;
        }

        //保存用户基础数据
        UserInfoPo userInfoPo = new UserInfoPo();
        BeanUtils.copyProperties(userInfoVo, userInfoPo);
        userInfoPo.setId(UUID.randomUUID().toString());
        userInfoPo = userInfoDataCurd.save(userInfoPo);
        WeiXinUserInfoPo weiXinUserInfoPo = new WeiXinUserInfoPo();
        weiXinUserInfoPo.setId(UUID.randomUUID().toString());
        weiXinUserInfoPo.setOpenid(userInfoVo.getOpenid());
        weiXinUserInfoPo.setUserId(userInfoPo.getId());
        //保存关联数据
        weiXinUserInfoPo = weiXinUserInfoCurd.save(weiXinUserInfoPo);
        return userInfoPo != null && weiXinUserInfoPo != null;
    }

    public List<UserInfoVo> findByDepartMentName(String departMentName) {
        List<UserInfoPo> userInfoPos = userInfoDataCurd.findByDepartMentName(departMentName);
        if(!CollectionUtils.isEmpty(userInfoPos)) {
            return userInfoPos.stream().map(e -> {
                UserInfoVo userInfoVo = new UserInfoVo();
                BeanUtils.copyProperties(e, userInfoVo);
                userInfoVo.setUserCode(e.getId());
                return userInfoVo;
            }).collect(Collectors.toList());
        }
        return null;
    }

    public List<UserInfoVo> findAllUser() {
        List<UserInfoPo> userInfoPos = (List<UserInfoPo>) userInfoDataCurd.findAll();
        if(!CollectionUtils.isEmpty(userInfoPos)) {
            return userInfoPos.stream().map(e -> {
                UserInfoVo userInfoVo = new UserInfoVo();
                BeanUtils.copyProperties(e, userInfoVo);
                userInfoVo.setUserCode(e.getId());
                return userInfoVo;
            }).collect(Collectors.toList());
        }
        return null;
    }

    public UserInfoVo findByUserId(String userId) {
        Optional<UserInfoPo> userInfoPoOpt = userInfoDataCurd.findById(userId);
        if(userInfoPoOpt.isPresent()) {
            UserInfoVo userInfoVo = new UserInfoVo();
            BeanUtils.copyProperties(userInfoPoOpt.get(), userInfoVo);
            return userInfoVo;
        } else {
            return null;
        }
    }
}
