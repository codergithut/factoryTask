package com.tianjian.factory.common;

import com.tianjian.factory.model.common.RestModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by tianjian on 2020/7/18.
 */
@RequestMapping("/common")
@RestController
public class ConstantConfigController {

    private static Map<String, String> dicMap = new HashMap<>();

    static {
        dicMap.put("active", "进行中");
        dicMap.put("finish", "完成");
        dicMap.put("wait", "等待");
    }

    /**
     * 创建模板元数据
     * @param taskStatus
     * @return
     */
    @GetMapping("/getActionName")
    public RestModel<String> getActionName(@RequestParam("taskStatus") String taskStatus) {
        String value = dicMap.get(taskStatus);
        return RestModel.success(value);
    }


}
