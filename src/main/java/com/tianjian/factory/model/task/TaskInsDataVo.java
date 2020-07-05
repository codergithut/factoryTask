package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

@ApiModel
public class TaskInsDataVo {

    @ApiModelProperty("实际子任务id")
    private String id;

    @ApiModelProperty("任务名称")
    private String taskName;

    @ApiModelProperty("服务器返回码")
    private TaskTemplateVo taskTemplate;

    @ApiModelProperty("当前任务数据")
    private Map<String, Object> datas;

    @ApiModelProperty("服务器返回码")
    private String taskStatus;

    @ApiModelProperty("处理人id")
    private String handleUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TaskTemplateVo getTaskTemplate() {
        return taskTemplate;
    }

    public void setTaskTemplate(TaskTemplateVo taskTemplate) {
        this.taskTemplate = taskTemplate;
    }

    public Map<String, Object> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, Object> datas) {
        this.datas = datas;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getHandleUserId() {
        return handleUserId;
    }

    public void setHandleUserId(String handleUserId) {
        this.handleUserId = handleUserId;
    }
}
