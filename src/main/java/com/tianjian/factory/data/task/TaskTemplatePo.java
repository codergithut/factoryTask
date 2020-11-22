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
     * task 元数据
     */
    private String taskTemplateTypeMeta;

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

    public String getTaskTemplateTypeMeta() {
        return taskTemplateTypeMeta;
    }

    public void setTaskTemplateTypeMeta(String taskTemplateTypeMeta) {
        this.taskTemplateTypeMeta = taskTemplateTypeMeta;
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
