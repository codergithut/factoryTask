package com.tianjian.factory.model.task;

import java.util.Date;

/**
 * Created by tianjian on 2020/6/27.
 */
public class WorkDetailDataVo {

    private String taskFlow;

    private String workName;

    private Date submitTime;

    private Date updateTime;

    private String taskManager;

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
