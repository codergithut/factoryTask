package com.tianjian.factory.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.tianjian.factory.model.common.RestModel;
import com.tianjian.factory.model.user.UserInfoVo;
import com.tianjian.factory.model.user.WeiXinLogin;
import com.tianjian.factory.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {

    String secretKey = "11563aa67bfedfa04777176081e240c2";
    String appid = "wxf9682b2d07b42000";

    String aesKey = "011t135FYNA8GE6JBsd947j7t3a4IfB9akbAnuZLFuW";

    @Autowired
    private UserService userService;


    /**
     * 根据openId 获取用户
     * @param openid
     * @return
     */
    @GetMapping("/getUserByOpenid")
    public RestModel getUserInfoByOpenid(@RequestParam("openid") String openid) {
        UserInfoVo userInfo = userService.getUserInfoByOpenId(openid);
        userInfo.setOpenid(openid);
        if(userInfo == null) {
            return RestModel.fail("000001", "not find user");
        } else {
            return RestModel.success(userInfo);
        }
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUserInfo")
    public RestModel getUserInfo(@RequestParam("code") String code,
                                 @RequestParam("encryptedData") String encryptedData,
                                 @RequestParam("iv") String iv) {
        String req = "https://api.weixin.qq.com/sns/jscode2session?appid=wxf9682b2d07b42000&secret=11563aa67bfedfa04777176081e240c2&js_code=$code&grant_type=authorization_code";
        String realReq = req.replace("$code", code);
        Map<String, Object> data = new HashMap<>();
        ResponseEntity<String> s = restTemplate.getForEntity(realReq, String.class);
        WeiXinLogin weiXinLogin = JSONObject.parseObject(s.getBody(), WeiXinLogin.class);
        String openid = weiXinLogin.getOpenid();
        UserInfoVo userInfo = userService.getUserInfoByOpenId(openid);
        userInfo.setOpenid(openid);
        data.put("openid", openid);
        data.put("userInfo", userInfo);
        return RestModel.success(data);

    }

    @PostMapping("/saveUserInfo")
    public RestModel saveUserInfo(@RequestBody UserInfoVo userInfoVo) {
        if(userInfoVo.getOpenid() == null ||
                userInfoVo.getDepartMentName() == null ||
                userInfoVo.getRole() ==null ||
                userInfoVo.getUserName() == null ||
                userInfoVo.getTelPhoneNum() == null){
            return RestModel.fail("000001", "use info error");
        }
        Boolean result =  userService.saveUserInfo(userInfoVo);
        return  result ? RestModel.success(result) : RestModel.fail("000001", "user add fail");
    }

    @GetMapping("/getUserByDepartmentName")
    public RestModel getUserByDepartMentId(@RequestParam("departMentName") String departMentName) {
        List<UserInfoVo> userInfoVos = userService.findByDepartMentName(departMentName);
        if(CollectionUtils.isEmpty(userInfoVos)) {
            return RestModel.fail("000001", "get data fail");
        }
        return RestModel.success(userInfoVos);
    }

    @GetMapping("/getAllUser")
    public RestModel getAllUser() {
        List<UserInfoVo> userInfoVos = userService.findAllUser();
        if(CollectionUtils.isEmpty(userInfoVos)) {
            return RestModel.fail("000001", "get data fail");
        }
        return RestModel.success(userInfoVos);
    }

    @GetMapping("/getUserByUserId")
    public RestModel getUserInfoByUserId(@RequestParam("userId") String userId) {
        UserInfoVo userInfoVo = userService.findByUserId(userId);
        if(userInfoVo == null) {
            return RestModel.fail("000001", "can not find user info");
        }
        return RestModel.success(userInfoVo);
    }

}
