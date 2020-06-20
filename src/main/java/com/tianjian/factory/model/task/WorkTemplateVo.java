package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel
public class WorkTemplateVo {

    @ApiModelProperty("服务器返回码")
    private String id;

    /**
     * 工作名称
     */
    @ApiModelProperty("工作名称")
    private String jobName;

    /**
     * 工作描述
     */
    @ApiModelProperty("工作描述")
    private String jobDesc;

    /**
     * 任务流程模板
     */
    @ApiModelProperty("任务流程模板")
    private List<WorkTemplateDetailVo> subTasks;

    /**
     * 启动时间
     */
    @ApiModelProperty("启动时间")
    private Date startDate;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private Date endDate;

    /**
     * 任务状态标识
     */
    @ApiModelProperty("任务状态")
    private String jobStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public List<WorkTemplateDetailVo> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<WorkTemplateDetailVo> subTasks) {
        this.subTasks = subTasks;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public static WorkTemplateVo mockData() {
        WorkTemplateVo workTemplateVo = new WorkTemplateVo();
        workTemplateVo.setEndDate(new Date());
        workTemplateVo.setStartDate(new Date());
        workTemplateVo.setJobName("work name");

        List<WorkTemplateDetailVo> workTemplateDetailVos = new ArrayList<>();

        WorkTemplateDetailVo workTemplateDetailVo = new WorkTemplateDetailVo();
        workTemplateDetailVo.setEndTime(new Date());
        workTemplateDetailVo.setHandleUserId("e4511a57-e1bb-4cb7-b590-0be8a7ea8a01");
        workTemplateDetailVo.setStartTime(new Date());
        workTemplateDetailVo.setTaskTemplateName("new task name");
        workTemplateDetailVo.setTaskTemplateId("0f43d5f6-ced6-4832-9884-bc83fc548440");

        workTemplateDetailVos.add(workTemplateDetailVo);
        workTemplateVo.setSubTasks(workTemplateDetailVos);

        return workTemplateVo;
    }
}
