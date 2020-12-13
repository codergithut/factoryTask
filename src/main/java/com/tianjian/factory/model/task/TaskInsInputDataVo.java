package com.tianjian.factory.model.task;

import java.util.Map;

public class TaskInsInputDataVo {

    private String taskInsDataCode;

    private Map<String, Object> data;

    public String getTaskInsDataCode() {
        return taskInsDataCode;
    }

    public void setTaskInsDataCode(String taskInsDataCode) {
        this.taskInsDataCode = taskInsDataCode;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
