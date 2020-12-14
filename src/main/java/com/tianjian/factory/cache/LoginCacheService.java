package com.tianjian.factory.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Service
public class LoginCacheService {

    Cache<String, String> userToken = CacheBuilder.newBuilder()
            .expireAfterWrite(60*60*24*30, TimeUnit.SECONDS)
            .build();

    Cache<String, String> registerTokenInfo = CacheBuilder.newBuilder()
            .expireAfterWrite(60*60*24*30, TimeUnit.SECONDS)
            .build();

    public void addUserToken(String token, String userId){
        String key = registerTokenInfo.getIfPresent(userId);
        if(key != null) {
            userToken.invalidate(key);
            registerTokenInfo.invalidate(userId);
        }
        userToken.put(token, userId);
        registerTokenInfo.put(userId, token);
    }

    public String getUserIdByRequest(HttpServletRequest request) {
        String token = (String) request.getHeader("token");
        return userToken.getIfPresent(token);
    }
}
