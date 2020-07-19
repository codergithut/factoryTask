package com.tianjian.factory.data.task;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;


@Entity
public class WorkInsDataPo {

    /**
     * 工作实例
     */
    @Id
    private String id;

    /**
     * 工作状态
     */
    private String workStatus;

    /**
     * 当前任务模板id
     */
    private String currentTaskTemplateId;

    /**
     * 任务模板
     */
    private String workTemplateId;

    /**
     * 任务次序
     */
    private int orderNum;

    /**
     * 当前处理人编号
     */
    private String handerUserId;

    /**
     * 流程总数
     */
    private int totalTaskNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
