package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by tianjian on 2020/12/17.
 */
@ApiModel("任务编辑数据")
public class TaskDataVo {

    @ApiModelProperty("模版详情")
    private List<TaskTemplateTypeMetaDetailVo> taskTemplateTypeMetaDetails;

    private String data;

    public List<TaskTemplateTypeMetaDetailVo> getTaskTemplateTypeMetaDetails() {
        return taskTemplateTypeMetaDetails;
    }

    public void setTaskTemplateTypeMetaDetails(List<TaskTemplateTypeMetaDetailVo> taskTemplateTypeMetaDetails) {
        this.taskTemplateTypeMetaDetails = taskTemplateTypeMetaDetails;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
