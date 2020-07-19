package com.tianjian.factory.data.task;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class TaskTemplatePo {

    /**
     * 模板id
     */
    @Id
    private String id;

    /**
     * 模板名称
     */
    private String taskTemplateName;


    /**
     * 模板类型 taskTemplateType 用，分割省的我在处理
     */
    private String taskTemplateTypes;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;


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

    public String getTaskTemplateTypes() {
        return taskTemplateTypes;
    }

    public void setTaskTemplateTypes(String taskTemplateTypes) {
        this.taskTemplateTypes = taskTemplateTypes;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
