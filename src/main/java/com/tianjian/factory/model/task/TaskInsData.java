package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

@ApiModel("任务数据")
public class TaskInsData {

    /**
     * 实际子任务id
     */
    @ApiModelProperty("编号")
    private String id;

    /**
     * 任务名称
     */
    @ApiModelProperty("任务名称")
    private String taskName;

    /**
     * 任务模板
     */
    @ApiModelProperty("任务模板")
    private TaskTemplateVo taskTemplate;

    /**
     * 当前任务数据
     */
    @ApiModelProperty("当前任务数据")
    private Map<String, Object> datas;

    /**
     * 当前子任务状态
     */
    @ApiModelProperty("当前任务状态")
    private String taskStatus;

    /**
     * 处理人id
     */
    @ApiModelProperty("处理人用户id")
    private String handleUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TaskTemplateVo getTaskTemplate() {
        return taskTemplate;
    }

    public void setTaskTemplate(TaskTemplateVo taskTemplate) {
        this.taskTemplate = taskTemplate;
    }

    public Map<String, Object> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, Object> datas) {
        this.datas = datas;
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
}
