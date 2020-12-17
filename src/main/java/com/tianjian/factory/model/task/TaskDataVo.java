package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;

/**
 * Created by tianjian on 2020/12/17.
 */
@ApiModel("任务编辑数据")
public class TaskDataVo {

    private TaskTemplateVo taskTemplateVo;

    private String data;

    public TaskTemplateVo getTaskTemplateVo() {
        return taskTemplateVo;
    }

    public void setTaskTemplateVo(TaskTemplateVo taskTemplateVo) {
        this.taskTemplateVo = taskTemplateVo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
