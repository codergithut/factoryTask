package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Map;

/**
 * Created by tianjian on 2020/6/27.
 */
@ApiModel("任务细节数据")
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

    @ApiModelProperty("子任务代码")
    private String taskDetailCode;

    @ApiModelProperty("顺序")
    private Integer orderNum;

    @ApiModelProperty("用户数据")
    private Map<String, String> data;

    @ApiModelProperty("用户元数据")
    private TaskTemplateVo taskTemplateVo;

    private String taskInsDataCode;

    public String getTaskDetailCode() {
        return taskDetailCode;
    }

    public void setTaskDetailCode(String taskDetailCode) {
        this.taskDetailCode = taskDetailCode;
    }

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

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public String getTaskInsDataCode() {
        return taskInsDataCode;
    }

    public void setTaskInsDataCode(String taskInsDataCode) {
        this.taskInsDataCode = taskInsDataCode;
    }

    public TaskTemplateVo getTaskTemplateVo() {
        return taskTemplateVo;
    }

    public void setTaskTemplateVo(TaskTemplateVo taskTemplateVo) {
        this.taskTemplateVo = taskTemplateVo;
    }
}
