package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel
public class TaskTemplateTypeMetaVo {

    /**
     * 模板类型
     */
    @ApiModelProperty("模板类型")
    private String taskTemplateType;

    /**
     * 模版详情
     */
    @ApiModelProperty("模版详情")
    private List<TaskTemplateTypeMetaDetailVo> taskTemplateTypeMetaDetails;

    public String getTaskTemplateType() {
        return taskTemplateType;
    }

    public void setTaskTemplateType(String taskTemplateType) {
        this.taskTemplateType = taskTemplateType;
    }

    public List<TaskTemplateTypeMetaDetailVo> getTaskTemplateTypeMetaDetails() {
        return taskTemplateTypeMetaDetails;
    }

    public void setTaskTemplateTypeMetaDetails(List<TaskTemplateTypeMetaDetailVo> taskTemplateTypeMetaDetails) {
        this.taskTemplateTypeMetaDetails = taskTemplateTypeMetaDetails;
    }

    public static TaskTemplateTypeMetaVo mockData() {
        TaskTemplateTypeMetaVo taskTemplateTypeMetaVo = new TaskTemplateTypeMetaVo();
        taskTemplateTypeMetaVo.setTaskTemplateType("userInfo");
        List<TaskTemplateTypeMetaDetailVo> taskTemplateTypeMetaDetailVos = new ArrayList<>();
        TaskTemplateTypeMetaDetailVo taskTemplateTypeMetaDetailVo = new TaskTemplateTypeMetaDetailVo();
        taskTemplateTypeMetaDetailVo.setIsRequired("required");
        taskTemplateTypeMetaDetailVo.setMetaName("userName");
        taskTemplateTypeMetaDetailVo.setMetaType("string");
        taskTemplateTypeMetaDetailVos.add(taskTemplateTypeMetaDetailVo);

        TaskTemplateTypeMetaDetailVo taskTemplateTypeMetaDetailVo1 = new TaskTemplateTypeMetaDetailVo();
        taskTemplateTypeMetaDetailVo1.setIsRequired("required");
        taskTemplateTypeMetaDetailVo1.setMetaName("passWord");
        taskTemplateTypeMetaDetailVo1.setMetaType("string");
        taskTemplateTypeMetaDetailVos.add(taskTemplateTypeMetaDetailVo1);

        taskTemplateTypeMetaVo.setTaskTemplateTypeMetaDetails(taskTemplateTypeMetaDetailVos);

        return taskTemplateTypeMetaVo;
    }
}
