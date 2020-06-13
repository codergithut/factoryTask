package com.tianjian.factory.model.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskTemplateVo {

    /**
     * 模板id
     */
    private String id;

    /**
     * 模板名称
     */
    private String taskTemplateName;

    /**
     * 模板类型具体数据
     */
    private List<TaskTemplateTypeMetaVo> taskTemplateTypeMetaVos;

    /**
     * 模板类型数据
     */
    private Set<String> taskTemplateTypes;


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

    public List<TaskTemplateTypeMetaVo> getTaskTemplateTypeMetaVos() {
        return taskTemplateTypeMetaVos;
    }

    public void setTaskTemplateTypeMetaVos(List<TaskTemplateTypeMetaVo> taskTemplateTypeMetaVos) {
        this.taskTemplateTypeMetaVos = taskTemplateTypeMetaVos;
    }

    public Set<String> getTaskTemplateTypes() {
        return taskTemplateTypes;
    }

    public void setTaskTemplateTypes(Set<String> taskTemplateTypes) {
        this.taskTemplateTypes = taskTemplateTypes;
    }

    public static TaskTemplateVo mockTaskTemplateVo() {
        TaskTemplateVo taskTemplateVo = new TaskTemplateVo();
        taskTemplateVo.setTaskTemplateName("test template");
        Set<String> v = new HashSet<>();
        v.add("userInfo");
        v.add("orderInfo");
        taskTemplateVo.setTaskTemplateTypes(v);
        return taskTemplateVo;
    }
}
