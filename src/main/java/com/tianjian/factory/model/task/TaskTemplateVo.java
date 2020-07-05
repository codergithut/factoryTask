package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@ApiModel
public class TaskTemplateVo {

    @ApiModelProperty("模板id")
    private String taskCode;

    @ApiModelProperty("模板名称")
    private String taskName;

    @ApiModelProperty("模板类型具体数据")
    private List<TaskTemplateTypeMetaVo> taskTemplateTypeMetaVos;

    @ApiModelProperty("模板类型数据")
    private Set<String> taskTemplateTypes;

    @ApiModelProperty("元数据具体数据")
    public List<TaskTemplateTypeMetaVo> getTaskTemplateTypeMetaVos() {
        return taskTemplateTypeMetaVos;
    }

    public void setTaskTemplateTypeMetaVos(List<TaskTemplateTypeMetaVo> taskTemplateTypeMetaVos) {
        this.taskTemplateTypeMetaVos = taskTemplateTypeMetaVos;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Set<String> getTaskTemplateTypes() {
        return taskTemplateTypes;
    }

    public void setTaskTemplateTypes(Set<String> taskTemplateTypes) {
        this.taskTemplateTypes = taskTemplateTypes;
    }

}
