package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@ApiModel("任务模板")
public class TaskTemplateVo {

    @ApiModelProperty("模板id")
    private String taskCode;

    @ApiModelProperty("模板名称")
    private String taskName;

    @ApiModelProperty("元数据具体数据")
    private TaskTemplateTypeMetaVo taskTemplateTypeMetaVo;

    @ApiModelProperty("元数据id")
    private String taskTemplateTypeMeta;


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

    public String getTaskTemplateTypeMeta() {
        return taskTemplateTypeMeta;
    }

    public void setTaskTemplateTypeMeta(String taskTemplateTypeMeta) {
        this.taskTemplateTypeMeta = taskTemplateTypeMeta;
    }

    public TaskTemplateTypeMetaVo getTaskTemplateTypeMetaVo() {
        return taskTemplateTypeMetaVo;
    }

    public void setTaskTemplateTypeMetaVo(TaskTemplateTypeMetaVo taskTemplateTypeMetaVo) {
        this.taskTemplateTypeMetaVo = taskTemplateTypeMetaVo;
    }
}
