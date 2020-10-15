package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by tianjian on 2020/6/27.
 */
@ApiModel("任务细节")
public class WorkDetailDataVo {

    @ApiModelProperty("模板id")
    private String taskFlow;

    @ApiModelProperty("工作名称")
    private String workName;

    @ApiModelProperty("提交时间")
    private Date submitTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("task管理人")
    private String taskManager;

    @ApiModelProperty("所属任务")
    private String belongs;

    public String getTaskFlow() {
        return taskFlow;
    }

    public void setTaskFlow(String taskFlow) {
        this.taskFlow = taskFlow;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
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
}
