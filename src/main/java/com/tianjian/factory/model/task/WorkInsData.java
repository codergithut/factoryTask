package com.tianjian.factory.model.task;

import java.util.List;

public class WorkInsData {
    /**
     * 工作实例
     */
    private String id;

    /**
     * 工作状态
     */
    private String workStatus;

    /**
     * 当前任务模板id
     */
    private String currentTemplateId;

    /**
     * 当前处理人编号
     */
    private List<String> handleUserIds;
}
