package com.tianjian.factory.model.task;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class WorkInsDataVo {
    /**
     * 工作状态
     */
    @ApiModelProperty("工作状态")
    private String workStatus;

    /**
     * 当前任务模板id
     */
    @ApiModelProperty("当前任务模板id")
    private String currentTaskTemplateId;

    /**
     * 任务模板
     */
    @ApiModelProperty("任务模板")
    private String workTemplateId;

    /**
     * 任务次序
     */
    @ApiModelProperty("任务次序")
    private int orderNum;

    /**
     * 当前处理人编号
     */
    @ApiModelProperty("当前处理人编号")
    private String handerUserId;

    /**
     * 流程总数
     */
    @ApiModelProperty("流程总数")
    private int totalTaskNum;

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getCurrentTaskTemplateId() {
        return currentTaskTemplateId;
    }

    public void setCurrentTaskTemplateId(String currentTaskTemplateId) {
        this.currentTaskTemplateId = currentTaskTemplateId;
    }

    public String getWorkTemplateId() {
        return workTemplateId;
    }

    public void setWorkTemplateId(String workTemplateId) {
        this.workTemplateId = workTemplateId;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getHanderUserId() {
        return handerUserId;
    }

    public void setHanderUserId(String handerUserId) {
        this.handerUserId = handerUserId;
    }

    public int getTotalTaskNum() {
        return totalTaskNum;
    }

    public void setTotalTaskNum(int totalTaskNum) {
        this.totalTaskNum = totalTaskNum;
    }
}
