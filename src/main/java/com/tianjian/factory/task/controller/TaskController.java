package com.tianjian.factory.task.controller;


import com.tianjian.factory.model.common.RestModel;
import com.tianjian.factory.model.task.TaskTemplateTypeMetaVo;
import com.tianjian.factory.model.task.TaskTemplateVo;
import com.tianjian.factory.model.task.WorkInsDataVo;
import com.tianjian.factory.model.task.WorkTemplateVo;
import com.tianjian.factory.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/task")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * 创建模板元数据
     * @param taskTemplateTypeMetaVos
     * @return
     */
    @PostMapping("/createTaskTemplateTypeMeta")
    public RestModel createTaskTemplateTypeMeta(@RequestBody List<TaskTemplateTypeMetaVo> taskTemplateTypeMetaVos) {
        boolean result = taskService.saveTaskTemplateTypeMeta(taskTemplateTypeMetaVos);
        return result ? RestModel.success(result) : RestModel.fail("000001", "create fail");
    }

    /**
     * 获取模板元数据按照模板类型
     * @param taskTemplateType
     * @return
     */
    @GetMapping("/getTaskTemplateTypeMeta")
    public RestModel getTaskTemplateTypeMeta(@RequestParam("taskTemplateType") String taskTemplateType) {
        TaskTemplateTypeMetaVo taskTemplateTypeMetaVo = taskService.findTaskTemplateTypeMetaByType(taskTemplateType);
        return RestModel.success(taskTemplateTypeMetaVo);
    }

    /**
     * 查询已有的元数据模板
     */
    @GetMapping("/getTaskTemplateType")
    public RestModel getTaskTemplateType() {
        Set<String> taskTemplateTypes = taskService.findAllTakTemplateType();
        return RestModel.success(taskTemplateTypes);

    }

    /**
     * 创建任务模板
     * @param taskTemplateVo
     * @return
     */
    @PostMapping("/createTaskTemplate")
    public RestModel createTaskTemplate(@RequestBody TaskTemplateVo taskTemplateVo) {
        boolean result = taskService.saveTaskTemplate(taskTemplateVo);
        return result ? RestModel.success(result) : RestModel.fail("000001", "create fail");
    }

    @GetMapping("/getTaskTemplateById")
    public RestModel getTaskTemplate(@RequestParam("taskTemplateId") String taskTemplateId) {
        TaskTemplateVo result = taskService.findByTaskTemplateId(taskTemplateId);
        return result != null ? RestModel.success(result) : RestModel.fail("000001", "create fail");
    }

    @PostMapping("/createWorkTemplate")
    public RestModel createWorkTemplate(@RequestBody WorkTemplateVo workTemplateVo) {
        boolean result = taskService.saveWorkTemplateVo(workTemplateVo);
        return result ? RestModel.success(result) : RestModel.fail("000001", "create work template fail");
    }

    @GetMapping("/getMyWork")
    public RestModel getMyWork(@RequestParam("userId") String userId) {
        List<WorkInsDataVo> workInsDataVos = taskService.getMyWork(userId);
        if(CollectionUtils.isEmpty(workInsDataVos)) {
            return RestModel.fail("000001", "get work fail");
        } else {
            return RestModel.success(workInsDataVos);
        }
    }

    @GetMapping("/startWork")
    public RestModel startWork(@RequestParam("workTemplateId") String workTemplateId) {
        boolean result = taskService.workProcess(workTemplateId, 0);
        return result ? RestModel.success(result) : RestModel.fail("000001", "start work fail");
    }

    @GetMapping("/submitWork")
    public RestModel submitWork(@RequestParam("workTemplateId") String workTemplateId) {
        boolean result = taskService.workSubmit(workTemplateId);
        return result ? RestModel.success(result) : RestModel.fail("000001", "start work fail");
    }

    @GetMapping("/rejectWork")
    public RestModel rejectWork(@RequestParam("workTemplateId") String workTemplateId,
                                @RequestParam("orderNum") Integer orderNum) {
        boolean result = taskService.workReject(workTemplateId, orderNum);
        return result ? RestModel.success(result) : RestModel.fail("000001", "start work fail");
    }

}
