package com.tianjian.factory.data.task;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class WorkTemplatePo {

    /**
     * 实际事件id
     */
    @Id
    private String id;

    /**
     * 任务启动时间
     */
    private Date startDate;

    /**
     * 工作名称
     */
    private String jobName;

    /**
     * 工作描述
     */
    private String jobDesc;

    /**
     * 任务结束时间
     */
    private Date endDate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
