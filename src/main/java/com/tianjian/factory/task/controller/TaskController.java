package com.tianjian.factory.task.controller;


import com.alibaba.fastjson.JSON;
import com.tianjian.factory.model.common.RestModel;
import com.tianjian.factory.model.task.*;
import com.tianjian.factory.task.service.TaskService;
import com.tianjian.factory.util.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

import static com.tianjian.factory.model.common.RestModel.success;

@RequestMapping("/task")
@RestController
@Slf4j
@Api("任务管理类")
public class TaskController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private TaskService taskService;

    /**
     * 创建模板元数据
     * @param taskTemplateTypeMetaVo
     * @return
     */
    @PostMapping("/createTaskTemplateTypeMeta")
    @ApiOperation(value = "创建元数据", notes = "创建元数据", httpMethod = "POST")
    public RestModel<Boolean> createTaskTemplateTypeMeta(@RequestBody TaskTemplateTypeMetaVo taskTemplateTypeMetaVo) {
        boolean result = taskService.saveTaskTemplateTypeMeta(taskTemplateTypeMetaVo);
        return result ? success(result) : RestModel.fail("0001", "create fail");
    }

    /**
     * 获取模板元数据按照模板类型
     * @param taskTemplateType
     * @return
     */
    @GetMapping("/getTaskTemplateTypeMeta")
    @ApiOperation(value = "获取元数据", notes = "获取元数据", httpMethod = "GET")
    public RestModel<TaskTemplateTypeMetaVo> getTaskTemplateTypeMeta(@RequestParam("taskTemplateType") String taskTemplateType) {
        TaskTemplateTypeMetaVo taskTemplateTypeMetaVo = taskService.findTaskTemplateTypeMetaByType(taskTemplateType);
        return success(taskTemplateTypeMetaVo);
    }

    @GetMapping("/getAllTaskTemplateTypeMetaInfo")
    @ApiOperation(value = "获取元数据列表", notes = "创建元数据", httpMethod = "GET")
    public RestModel<List<TaskTemplateTypeMetaVo>> getAllTaskTemplateTypeMeta() {
        return success(taskService.getAllTaskTempalteType());
    }

    /**
     * 查询已有的元数据模板
     */
    @GetMapping("/getTaskTemplateType")
    @ApiOperation(value = "获取所有工序列表", notes = "获取所有工序列表", httpMethod = "GET")
    public RestModel<Set<String>> getTaskTemplateType() {
        Set<String> taskTemplateTypes = taskService.findAllTakTemplateType();
        return success(taskTemplateTypes);

    }

    /**
     * 创建任务模板
     * @param taskTemplateVo
     * @return
     */
    @PostMapping("/createTaskTemplate")
    @ApiOperation(value = "创建任务模板", notes = "创建任务模板", httpMethod = "POST")
    public RestModel<Boolean> createTaskTemplate(@RequestBody TaskTemplateVo taskTemplateVo) {
        boolean result = taskService.saveTaskTemplate(taskTemplateVo);
        return result ? success(result) : RestModel.fail("0001", "create fail");
    }

    @GetMapping("/getTaskTemplateById")
    @ApiOperation(value = "根据id获取任务模板", notes = "根据id获取任务模板", httpMethod = "GET")
    public RestModel getTaskTemplate(@RequestParam("taskTemplateId") String taskTemplateId) {
        TaskTemplateVo result = taskService.findByTaskTemplateId(taskTemplateId);
        return result != null ? success(result) : RestModel.fail("0001", "create fail");
    }

    @PostMapping("/createWorkTemplate")
    @ApiOperation(value = "创建工作模板", notes = "创建工作模板", httpMethod = "POST")
    public RestModel<Boolean> createWorkTemplate(@RequestBody WorkTemplateVo workTemplateVo) {
        log.info("----" + JSON.toJSONString(workTemplateVo));
        boolean result = taskService.saveWorkTemplateVo(workTemplateVo);
        return result ? success(result) : RestModel.fail("0001", "create work template fail");
    }

    @GetMapping("/getAllTaskTemplates")
    @ApiOperation(value = "获取任务模板列表", notes = "获取任务模板列表", httpMethod = "GET")
    public RestModel<List<TaskTemplateVo>> getAllTaskTemplates() {
        List<TaskTemplateVo> taskTemplateVos = taskService.getAllTaskTemplates();
        return RestModel.success(taskTemplateVos);
    }

    @GetMapping("/getMyWorks")
    @ApiOperation(value = "获取我的工作", notes = "获取我的工作", httpMethod = "GET")
    public RestModel<List<WorkTemplateVo>> getMyWork() {
        String userId = RequestUtil.getUserCodeBySession(request);
        List<WorkTemplateVo> workTemplateVos = taskService.getMyWork(userId);
        return success(workTemplateVos);
    }

    @GetMapping("/getWorks")
    @ApiOperation(value = "获取所有工作", notes = "获取所有工作", httpMethod = "GET")
    public RestModel getAllWork() {
        List<WorkTemplateVo> workInsDataVos = taskService.getAllWork();
        return success(workInsDataVos);
    }

    @GetMapping("/startWork")
    @ApiOperation(value = "开始工作", notes = "开始工作", httpMethod = "GET")
    public RestModel<Boolean> startWork(@RequestParam("workTemplateId") String workTemplateId) {
        boolean result = taskService.workProcess(workTemplateId, 0);
        return result ? success(result) : RestModel.fail("0001", "start work fail");
    }

    @GetMapping("/submitWork")
    @ApiOperation(value = "提交工作", notes = "提交工作", httpMethod = "GET")
    public RestModel<Boolean> submitWork(@RequestParam("workTemplateId") String workDetailCode) {
        boolean result = taskService.workSubmit(workDetailCode);
        log.info("submitWork param is {}", workDetailCode);
        return result ? success(result) : RestModel.fail("0001", "start work fail");
    }

    @GetMapping("/bossSubmitWork")
    @ApiOperation(value = "boss提交工作", notes = "boss提交工作", httpMethod = "GET")
    public RestModel<Boolean> bossSubmitWork(@RequestParam("workDetailCode") String workDetailCode) {
        boolean result = taskService.bossSubmitWork(workDetailCode);
        return result ? success(result) : RestModel.fail("0001", "start work fail");
    }

    @GetMapping("/rejectWork")
    @ApiOperation(value = "驳回任务", notes = "驳回任务", httpMethod = "GET")
    public RestModel<Boolean> rejectWork(@RequestParam("workDetailCode") String workDetailCode) {
        boolean result = taskService.bosssRejectWork(workDetailCode);
        return result ? success(result) : RestModel.fail("0001", "start work fail");
    }

    @GetMapping("/getTaskInsInfo")
    @ApiOperation(value = "获取任务信息", notes = "获取任务信息", httpMethod = "GET")
    public RestModel<TaskDetailDataVo> getTaskInsInfo(@RequestParam("workTemplateId") String workTemplateId) {
        String userId = RequestUtil.getUserCodeBySession(request);
        TaskDetailDataVo taskDetailDataVo = taskService.findTaskInsInfo(workTemplateId, userId);
        return RestModel.success(taskDetailDataVo);

    }

    @GetMapping("/getWorkDetailByWorkId")
    @ApiOperation(value = "获取工作详情", notes = "获取工作详情", httpMethod = "GET")
    public RestModel<WorkDetailInfoVo> getWorkDetailByWorkId(@RequestParam("workTemplateId") String workTemplateId) {
        WorkDetailInfoVo workDetailInfoVo = new WorkDetailInfoVo();
        WorkTemplateVo workTemplateVo = taskService.getWorkInfoById(workTemplateId);
        List<TaskDetailDataVo> taskDetailDataVos = taskService.findWorkInfoAndWorkId(workTemplateId);
        workDetailInfoVo.setTaskDetailDatas(taskDetailDataVos);
        workDetailInfoVo.setWorkTemplateVo(workTemplateVo);
        return RestModel.success(workDetailInfoVo);

    }

    @GetMapping("/getTaskInsInfoDetailById")
    @ApiOperation(value = "获取任务信息", notes = "获取任务信息", httpMethod = "GET")
    public RestModel<TaskDetailDataVo> getTaskInsInfoDetailById(@RequestParam("taskDetailCode") String taskDetailCode) {
        TaskDetailDataVo taskDetailDataVo = taskService.findTaskDetailByCode(taskDetailCode);
        return RestModel.success(taskDetailDataVo);
    }
}
