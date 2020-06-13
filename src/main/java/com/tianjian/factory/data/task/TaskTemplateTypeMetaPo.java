package com.tianjian.factory.data.task;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskTemplateTypeMetaPo {

    /**
     * 数据id
     */
    @Id
    private String id;

    /**
     * 模板类型
     */
    private String taskTemplateType;

    /**
     * 数据key
     */
    private String metaName;

    /**
     * 数据类型
     */
    private String metaType;

    /**
     * 是否必填
     */
    private String isRequired;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskTemplateType() {
        return taskTemplateType;
    }

    public void setTaskTemplateType(String taskTemplateType) {
        this.taskTemplateType = taskTemplateType;
    }

    public String getMetaName() {
        return metaName;
    }

    public void setMetaName(String metaName) {
        this.metaName = metaName;
    }

    public String getMetaType() {
        return metaType;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
    }

    public String getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired;
    }
}
