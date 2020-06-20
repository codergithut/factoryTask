package com.tianjian.factory.model.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TaskTemplateVo {

    /**
     * 模板id
     */
    private String taskCode;

    /**
     * 模板名称
     */
    private String taskName;

    /**
     * 模板类型具体数据
     */
    private List<TaskTemplateTypeMetaVo> taskTemplateTypeMetaVos;

    /**
     * 模板类型数据
     */
    private Set<String> taskTemplateTypes;


    public List<TaskTemplateTypeMetaVo> getTaskTemplateTypeMetaVos() {
        return taskTemplateTypeMetaVos;
    }

    public void setTaskTemplateTypeMetaVos(List<TaskTemplateTypeMetaVo> taskTemplateTypeMetaVos) {
        this.taskTemplateTypeMetaVos = taskTemplateTypeMetaVos;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Set<String> getTaskTemplateTypes() {
        return taskTemplateTypes;
    }

    public void setTaskTemplateTypes(Set<String> taskTemplateTypes) {
        this.taskTemplateTypes = taskTemplateTypes;
    }

    public static TaskTemplateVo mockTaskTemplateVo() {
        TaskTemplateVo taskTemplateVo = new TaskTemplateVo();
        taskTemplateVo.setTaskCode(UUID.randomUUID().toString());
        taskTemplateVo.setTaskName("taskName");
        Set<String> v = new HashSet<>();
        v.add("userInfo");
        v.add("orderInfo");
        taskTemplateVo.setTaskTemplateTypes(v);
        return taskTemplateVo;
    }

}
