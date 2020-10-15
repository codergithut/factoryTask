package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("工作节点实例数据")
public class WorkInsData {
    /**
     * 工作实例
     */
    @ApiModelProperty("id")
    private String id;

    /**
     * 工作状态
     */
    @ApiModelProperty("工作状态")
    private String workStatus;

    /**
     * 当前任务模板id
     */
    @ApiModelProperty("当前任务状态")
    private String currentTemplateId;

    /**
     * 当前处理人编号
     */
    @ApiModelProperty("处理人员信息")
    private List<String> handleUserIds;

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

    public String getCurrentTemplateId() {
        return currentTemplateId;
    }

    public void setCurrentTemplateId(String currentTemplateId) {
        this.currentTemplateId = currentTemplateId;
    }

    public List<String> getHandleUserIds() {
        return handleUserIds;
    }

    public void setHandleUserIds(List<String> handleUserIds) {
        this.handleUserIds = handleUserIds;
    }
}
