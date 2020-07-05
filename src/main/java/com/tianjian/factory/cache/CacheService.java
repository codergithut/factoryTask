package com.tianjian.factory.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.tianjian.factory.data.task.TaskInsDataPo;
import com.tianjian.factory.model.task.TaskTemplateVo;
import com.tianjian.factory.model.task.WorkTemplateVo;
import com.tianjian.factory.model.user.UserInfoVo;
import com.tianjian.factory.task.service.TaskService;
import com.tianjian.factory.user.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CacheService {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    Cache<String, String> userNames = CacheBuilder.newBuilder()
            .expireAfterWrite(60*60*24*30, TimeUnit.SECONDS)
            .build();

    Cache<String, String> taskNames = CacheBuilder.newBuilder()
            .expireAfterWrite(60*60*24*30, TimeUnit.SECONDS)
            .build();

    Cache<String, String> workNames = CacheBuilder.newBuilder()
            .expireAfterWrite(60*60*24*30, TimeUnit.SECONDS)
            .build();

    public void setUserName(String key, String value) {
        userNames.put(key, value);
    }

    /**
     * 根据用户id获取用户名
     * @param key
     * @return
     */
    public String getUserName(String key) {
        if(userNames.getIfPresent(key) == null) {
            UserInfoVo userInfoVo = userService.findByUserId(key);
            if(userInfoVo == null) {
                return null;
            }
            userNames.put(key, userInfoVo.getUserName());
        }
        return userNames.getIfPresent(key);
    }


    /**
     * 更具task
     * @param key
     * @return
     */
    public String getTaskInfo(String key) {
        if(taskNames.getIfPresent(key) == null) {
            TaskTemplateVo taskTemplateVo =  taskService.findByTaskTemplateId(key);
           if(taskTemplateVo == null) {
               return null;
           }
           taskNames.put(key, taskTemplateVo.getTaskName());
        }
        return taskNames.getIfPresent(key);
    }


    public String getWorkName(String key) {
        if(workNames.getIfPresent(key) == null) {
            WorkTemplateVo workTemplateVo = taskService.getWorkInfoById(key);
            if(workTemplateVo == null) {
                return null;
            }
            workNames.put(key, workTemplateVo.getJobName());
        }
        return workNames.getIfPresent(key);
    }


}
