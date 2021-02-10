package com.tianjian.factory.core.controller;

import com.alibaba.fastjson.JSON;
import com.tianjian.factory.core.model.WorkDataDTO;
import com.tianjian.factory.core.service.WorkFlowService;
import com.tianjian.factory.model.common.RestModel;
import com.tianjian.factory.model.task.TaskInsInputDataVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by tianjian on 2021/2/9.
 */
@RequestMapping("/task")
@RestController
@Slf4j
@Api("任务管理类")
@CrossOrigin
public class CoreController {

    @Autowired
    private WorkFlowService workFlowService;

    @PostMapping("/createWorkData")
    @ApiOperation(value = "编辑节点用户数据", notes = "编辑节点用户数据", httpMethod = "POST")
    public RestModel createTaskData(@RequestBody WorkDataDTO workDataDTO) {
        WorkDataDTO result = workFlowService.createWorkData(WorkDataDTO.mockWorkDataDTO(), "1");
        return RestModel.success(result);
    }


    @GetMapping("/initUserData")
    public RestModel initUserData(@RequestParam("userCode") String userCode) {
        WorkDataDTO workDataDTO = workFlowService.initWorkDataByUserCode(userCode);
        return RestModel.success(workDataDTO);
    }

    @GetMapping("/startUserWork")
    public RestModel startWork(@RequestParam("workDataCode") String workDataCode,
                               @RequestParam("userCode") String userCode) {
        WorkDataDTO workDataDTO = workFlowService.startWork(workDataCode, userCode);
        return RestModel.success(workDataDTO);
    }


    //96703b16-60a4-47d7-a8a3-9a77b0347be8

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(WorkDataDTO.mockWorkDataDTO()));
    }
}
