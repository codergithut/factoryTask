package com.tianjian.factory.data.task;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Map;

@Entity
public class TaskInsDataPo {

    /**
     * 实际子任务id
     */
    @Id
    private String id;

    /**
     * 任务名称
     */
    private String taskTemplateName;

    /**
     * 主任务id
     */
    private String workTemplateId;

    /**
     * 任务模板
     */
    private String taskTemplateId;

    /**
     * 当前任务数据
     */
    private String resourceId;

    /**
     * 当前子任务状态
     */
    private String taskStatus;

    /**
     * 处理人id
     */
    private String handleUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskTemplateName() {
        return taskTemplateName;
    }

    public void setTaskTemplateName(String taskTemplateName) {
        this.taskTemplateName = taskTemplateName;
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

    public String getTaskTemplateId() {
        return taskTemplateId;
    }

    public void setTaskTemplateId(String taskTemplateId) {
        this.taskTemplateId = taskTemplateId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getWorkTemplateId() {
        return workTemplateId;
    }

    public void setWorkTemplateId(String workTemplateId) {
        this.workTemplateId = workTemplateId;
    }
}
