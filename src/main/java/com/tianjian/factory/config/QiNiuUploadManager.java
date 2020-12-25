package com.tianjian.factory.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by tianjian on 2020/12/17.
 */
public class QiNiuUploadManager {


    private UploadManager uploadManager;

    private String authToken;

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    public void setUploadManager(UploadManager uploadManager) {
        this.uploadManager = uploadManager;
    }

    public void setAuth(String authToken) {
        this.authToken = authToken;
    }

    public UploadManager getUploadManager() {
        return uploadManager;
    }

    public String getAuthToken() throws UnsupportedEncodingException {

        if(!StringUtils.isNullOrEmpty(authToken)) {
            String expireTime = authToken.split(":")[2];
            final Base64.Decoder decoder = Base64.getDecoder();
            String expireValue = new String(decoder.decode(expireTime), "UTF-8");
            JSONObject jsonObject = JSON.parseObject(expireValue);
            Integer time = (Integer) jsonObject.get("deadline");
            boolean isExpire = (time - System.currentTimeMillis()/1000 < 0) ? true : false;
            if(isExpire) {
                Auth auth = Auth.create(accessKey, secretKey);
                setAuthToken(auth.uploadToken(bucket));
            }
        } else {
            Auth auth = Auth.create(accessKey, secretKey);
            setAuthToken(auth.uploadToken(bucket));
        }
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
