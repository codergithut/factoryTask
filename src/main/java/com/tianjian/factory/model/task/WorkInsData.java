package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class WorkInsData {
    /**
     * 工作实例
     */
    @ApiModelProperty("服务器返回码")
    private String id;

    /**
     * 工作状态
     */
    @ApiModelProperty("服务器返回码")
    private String workStatus;

    /**
     * 当前任务模板id
     */
    @ApiModelProperty("服务器返回码")
    private String currentTemplateId;

    /**
     * 当前处理人编号
     */
    @ApiModelProperty("服务器返回码")
    private List<String> handleUserIds;
}
