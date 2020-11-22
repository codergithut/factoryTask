package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("工作详细数据")
public class WorkDetailInfoVo {

    @ApiModelProperty("工作模板")
    private WorkTemplateVo workTemplateVo;

    @ApiModelProperty("任务详情")
    private List<TaskDetailDataVo> taskDetailDatas;

    public WorkTemplateVo getWorkTemplateVo() {
        return workTemplateVo;
    }

    public void setWorkTemplateVo(WorkTemplateVo workTemplateVo) {
        this.workTemplateVo = workTemplateVo;
    }

    public List<TaskDetailDataVo> getTaskDetailDatas() {
        return taskDetailDatas;
    }

    public void setTaskDetailDatas(List<TaskDetailDataVo> taskDetailDatas) {
        this.taskDetailDatas = taskDetailDatas;
    }
}
