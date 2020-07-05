package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by tianjian on 2020/6/27.
 */
@ApiModel
public class TaskDetailDataVo {

    @ApiModelProperty("任务名称")
    private String taskFlow;

    @ApiModelProperty("提交时间")
    private Date submitTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("任务执行人")
    private String taskManager;

    @ApiModelProperty("所属主要任务")
    private String belongs;

    @ApiModelProperty("任务状态")
    private String taskStatus;

    public String getTaskFlow() {
        return taskFlow;
    }

    public void setTaskFlow(String taskFlow) {
        this.taskFlow = taskFlow;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTaskManager() {
        return taskManager;
    }

    public void setTaskManager(String taskManager) {
        this.taskManager = taskManager;
    }

    public String getBelongs() {
        return belongs;
    }

    public void setBelongs(String belongs) {
        this.belongs = belongs;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
