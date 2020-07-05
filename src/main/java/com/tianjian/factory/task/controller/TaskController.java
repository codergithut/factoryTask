package com.tianjian.factory.task.controller;


import com.tianjian.factory.model.common.RestModel;
import com.tianjian.factory.model.task.*;
import com.tianjian.factory.task.service.TaskService;
import com.tianjian.factory.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

import static com.tianjian.factory.model.common.RestModel.success;

@RequestMapping("/task")
@RestController
public class TaskController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private TaskService taskService;

    /**
     * 创建模板元数据
     * @param taskTemplateTypeMetaVos
     * @return
     */
    @PostMapping("/createTaskTemplateTypeMeta")
    public RestModel<Boolean> createTaskTemplateTypeMeta(@RequestBody List<TaskTemplateTypeMetaVo> taskTemplateTypeMetaVos) {
        boolean result = taskService.saveTaskTemplateTypeMeta(taskTemplateTypeMetaVos);
        return result ? success(result) : RestModel.fail("000001", "create fail");
    }

    /**
     * 获取模板元数据按照模板类型
     * @param taskTemplateType
     * @return
     */
    @GetMapping("/getTaskTemplateTypeMeta")
    public RestModel<TaskTemplateTypeMetaVo> getTaskTemplateTypeMeta(@RequestParam("taskTemplateType") String taskTemplateType) {
        TaskTemplateTypeMetaVo taskTemplateTypeMetaVo = taskService.findTaskTemplateTypeMetaByType(taskTemplateType);
        return success(taskTemplateTypeMetaVo);
    }

    /**
     * 查询已有的元数据模板
     */
    @GetMapping("/getTaskTemplateType")
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
    public RestModel<Boolean> createTaskTemplate(@RequestBody TaskTemplateVo taskTemplateVo) {
        boolean result = taskService.saveTaskTemplate(taskTemplateVo);
        return result ? success(result) : RestModel.fail("000001", "create fail");
    }

    @GetMapping("/getTaskTemplateById")
    public RestModel getTaskTemplate(@RequestParam("taskTemplateId") String taskTemplateId) {
        TaskTemplateVo result = taskService.findByTaskTemplateId(taskTemplateId);
        return result != null ? success(result) : RestModel.fail("000001", "create fail");
    }

    @PostMapping("/createWorkTemplate")
    public RestModel<Boolean> createWorkTemplate(@RequestBody WorkTemplateVo workTemplateVo) {
        boolean result = taskService.saveWorkTemplateVo(workTemplateVo);
        return result ? success(result) : RestModel.fail("000001", "create work template fail");
    }

    @GetMapping("/getAllTaskTemplates")
    public RestModel<List<TaskTemplateVo>> getAllTaskTemplates() {
        List<TaskTemplateVo> taskTemplateVos = taskService.getAllTaskTemplates();
        if(!CollectionUtils.isEmpty(taskTemplateVos)){
            return RestModel.success(taskTemplateVos);
        } else {
            return RestModel.fail("000001", "getTaskTemplate fail");
        }
    }

    @GetMapping("/getMyWorks")
    public RestModel<List<WorkTemplateVo>> getMyWork() {
        String userId = RequestUtil.getUserCodeBySession(request);
        List<WorkTemplateVo> workTemplateVos = taskService.getMyWork(userId);
        if(CollectionUtils.isEmpty(workTemplateVos)) {
            return RestModel.fail("000001", "get work fail");
        } else {
            return success(workTemplateVos);
        }
    }

    @GetMapping("/getWorks")
    public RestModel getAllWork() {
        List<WorkTemplateVo> workInsDataVos = taskService.getAllWork();
        if(CollectionUtils.isEmpty(workInsDataVos)) {
            return RestModel.fail("000001", "get work fail");
        } else {
            return success(workInsDataVos);
        }
    }

    @GetMapping("/startWork")
    public RestModel<Boolean> startWork(@RequestParam("workTemplateId") String workTemplateId) {
        boolean result = taskService.workProcess(workTemplateId, 0);
        return result ? success(result) : RestModel.fail("000001", "start work fail");
    }

    @GetMapping("/submitWork")
    public RestModel<Boolean> submitWork(@RequestParam("workTemplateId") String workTemplateId) {
        boolean result = taskService.workSubmit(workTemplateId);
        return result ? success(result) : RestModel.fail("000001", "start work fail");
    }

    @GetMapping("/rejectWork")
    public RestModel<Boolean> rejectWork(@RequestParam("workTemplateId") String workTemplateId,
                                @RequestParam("orderNum") Integer orderNum) {
        boolean result = taskService.workReject(workTemplateId, orderNum);
        return result ? success(result) : RestModel.fail("000001", "start work fail");
    }

    @GetMapping("/getTaskInsInfo")
    public RestModel<TaskDetailDataVo> getTaskInsInfo(@RequestParam("workTemplateId") String workTemplateId) {
        String userId = RequestUtil.getUserCodeBySession(request);
        TaskDetailDataVo taskDetailDataVo = taskService.findTaskInsInfo(workTemplateId, userId);
        return RestModel.success(taskDetailDataVo);

    }

    @GetMapping("/getWorkDetailByWorkId")
    public RestModel<WorkDetailInfoVo> getWorkDetailByWorkId(@RequestParam("workTemplateId") String workTemplateId) {
        WorkDetailInfoVo workDetailInfoVo = new WorkDetailInfoVo();
        WorkTemplateVo workTemplateVo = taskService.getWorkInfoById(workTemplateId);
        List<TaskDetailDataVo> taskDetailDataVos = taskService.findWorkInfoAndWorkId(workTemplateId);
        workDetailInfoVo.setTaskDetailDatas(taskDetailDataVos);
        workDetailInfoVo.setWorkTemplateVo(workTemplateVo);
        return RestModel.success(workDetailInfoVo);

    }

    @GetMapping("/getTaskInsInfoDetailById")
    public RestModel<TaskDetailDataVo> getTaskInsInfoDetailById(@RequestParam("taskDetailCode") String taskDetailCode) {
        TaskDetailDataVo taskDetailDataVo = taskService.findTaskDetailByCode(taskDetailCode);
        return RestModel.success(taskDetailDataVo);
    }


}
