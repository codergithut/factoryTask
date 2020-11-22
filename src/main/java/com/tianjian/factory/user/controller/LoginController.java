package com.tianjian.factory.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.tianjian.factory.model.common.RestModel;
import com.tianjian.factory.model.user.UserInfoVo;
import com.tianjian.factory.model.user.WeiXinLogin;
import com.tianjian.factory.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api("用户管理")
public class LoginController {

    String secretKey = "11563aa67bfedfa04777176081e240c2";
    String appid = "wxf9682b2d07b42000";

    String aesKey = "011t135FYNA8GE6JBsd947j7t3a4IfB9akbAnuZLFuW";

    @Autowired
    private UserService userService;


    /**
     * 根据openId 获取用户
     * @return
     */
    @GetMapping("/getUserByOpenid")
    @ApiOperation(value = "根据openid获取用户信息", notes = "根据openid获取用户信息", httpMethod = "GET")
    public RestModel getUserInfoByOpenid() {
        String openid = request.getHeader("openid");
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

    @GetMapping("/getOpenid")
    @ApiOperation(value = "获取openid", notes = "获取openid", httpMethod = "GET")
    public RestModel<Map<String,Object>> getUserInfo(@RequestParam("code") String code,
                                 @RequestParam("encryptedData") String encryptedData,
                                 @RequestParam("iv") String iv) {
        String req = "https://api.weixin.qq.com/sns/jscode2session?appid=wxf9682b2d07b42000&secret=11563aa67bfedfa04777176081e240c2&js_code=$code&grant_type=authorization_code";
        String realReq = req.replace("$code", code);
        Map<String, Object> data = new HashMap<>();
        ResponseEntity<String> s = restTemplate.getForEntity(realReq, String.class);
        WeiXinLogin weiXinLogin = JSONObject.parseObject(s.getBody(), WeiXinLogin.class);
        String openid = weiXinLogin.getOpenid();
        UserInfoVo userInfo = userService.getUserInfoByOpenId(openid);
        if(userInfo != null) {
            userInfo.setOpenid(openid);
        }
        data.put("openid", openid);
        return RestModel.success(data);

    }

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/saveUserInfo")
    @ApiOperation(value = "保存用户信息", notes = "保存用户信息", httpMethod = "POST")
    public RestModel<Boolean> saveUserInfo(@RequestBody UserInfoVo userInfoVo) {
        if(userInfoVo.getDepartMentName() == null ||
                userInfoVo.getUserName() == null ||
                userInfoVo.getTelPhoneNum() == null){
            return RestModel.fail("000000", "use info error");
        }
        String openid = request.getHeader("openid");
        userInfoVo.setOpenid(openid);
        userInfoVo.setRole("null");
        Boolean result =  userService.saveUserInfo(userInfoVo);
        return  result ? RestModel.success(result) : RestModel.fail("000000", "user add fail");
    }

    @GetMapping("/editUserInfo")
    @ApiOperation(value = "编辑用户信息", notes = "编辑用户信息", httpMethod = "GET")
    public RestModel<Boolean> editUserInfo(@RequestParam("userName") String userName,
                                           @RequestParam("role") String role) {
        Boolean result = userService.editUserInfo(userName, role);
        return result ? RestModel.success(result) : RestModel.fail("000000", "user add fail");

    }

    @GetMapping("/getUserByToken")
    @ApiOperation(value = "根据openid获取用户信息", notes = "根据openid获取用户信息", httpMethod = "GET")
    public RestModel<UserInfoVo> getUserByToken() {
        String openid = request.getHeader("openid");
        UserInfoVo userInfo = userService.getUserInfoByOpenId(openid);
        if(userInfo != null) {
            userInfo.setOpenid(openid);
        }
        return RestModel.success(userInfo);

    }

    @GetMapping("/getUserByDepartmentName")
    @ApiOperation(value = "根据部门获取用户信息", notes = "根据部门获取用户信息", httpMethod = "GET")
    public RestModel<List<UserInfoVo>> getUserByDepartMentId(@RequestParam("departMentName") String departMentName) {
        List<UserInfoVo> userInfoVos = userService.findByDepartMentName(departMentName);
        if(CollectionUtils.isEmpty(userInfoVos)) {
            return RestModel.fail("000000", "get data fail");
        }
        return RestModel.success(userInfoVos);
    }

    @GetMapping("/getAllUser")
    @ApiOperation(value = "获取所有用户", notes = "获取所有用户", httpMethod = "GET")
    public RestModel<List<UserInfoVo>> getAllUser() {
        List<UserInfoVo> userInfoVos = userService.findAllUser();
        if(CollectionUtils.isEmpty(userInfoVos)) {
            return RestModel.fail("000000", "get data fail");
        }
        return RestModel.success(userInfoVos);
    }

    @GetMapping("/getUserByUserId")
    @ApiOperation(value = "根据用户id获取用户", notes = "根据用户id获取用户", httpMethod = "GET")
    public RestModel<UserInfoVo> getUserInfoByUserId(@RequestParam("userId") String userId) {
        UserInfoVo userInfoVo = userService.findByUserId(userId);
        if(userInfoVo == null) {
            return RestModel.fail("000000", "can not find user info");
        }
        return RestModel.success(userInfoVo);
    }

}
