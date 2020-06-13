package com.tianjian.factory.model.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkTemplateVo {

    private String id;

    /**
     * 工作名称
     */
    private String workName;

    /**
     * 任务流程模板
     */
    private List<WorkTemplateDetailVo> workTemplateDetailVos;

    /**
     * 启动时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<WorkTemplateDetailVo> getWorkTemplateDetailVos() {
        return workTemplateDetailVos;
    }

    public void setWorkTemplateDetailVos(List<WorkTemplateDetailVo> workTemplateDetailVos) {
        this.workTemplateDetailVos = workTemplateDetailVos;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
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

    public static WorkTemplateVo mockData() {
        WorkTemplateVo workTemplateVo = new WorkTemplateVo();
        workTemplateVo.setEndDate(new Date());
        workTemplateVo.setStartDate(new Date());
        workTemplateVo.setWorkName("work name");

        List<WorkTemplateDetailVo> workTemplateDetailVos = new ArrayList<>();

        WorkTemplateDetailVo workTemplateDetailVo = new WorkTemplateDetailVo();
        workTemplateDetailVo.setEndTime(new Date());
        workTemplateDetailVo.setHandleUserId("e4511a57-e1bb-4cb7-b590-0be8a7ea8a01");
        workTemplateDetailVo.setStartTime(new Date());
        workTemplateDetailVo.setTaskTemplateName("new task name");
        workTemplateDetailVo.setTaskTemplateId("0f43d5f6-ced6-4832-9884-bc83fc548440");

        workTemplateDetailVos.add(workTemplateDetailVo);
        workTemplateVo.setWorkTemplateDetailVos(workTemplateDetailVos);

        return workTemplateVo;
    }
}
