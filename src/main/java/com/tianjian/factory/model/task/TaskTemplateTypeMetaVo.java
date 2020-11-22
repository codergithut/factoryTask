package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("任务元数据")
public class TaskTemplateTypeMetaVo {

    @ApiModelProperty("模板类型")
    private String taskTemplateType;

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
}
