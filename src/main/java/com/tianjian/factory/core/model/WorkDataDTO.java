package com.tianjian.factory.core.model;

import com.tianjian.factory.core.model.constant.DataStatus;
import com.tianjian.factory.core.model.constant.WorkStatus;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by tianjian on 2021/2/8.
 */
public class WorkDataDTO {

    //工作请求编码
    private String workDataCode;

    //工作名称
    private String workName;

    //启动时间
    private Date startDate;

    //结束时间
    private Date endDate;

    //工作详情
    private List<WorkDataDetailDTO> workDataDetailDTOS;

    //工作流记录
    private List<WorkDataRecordDTO> workDataRecordDTOS;

    //工作状态
    private WorkStatus workStatus;

    //创建时间
    private Date createDate;

    //更新时间
    private Date updateDate;

    private DataStatus dataStatus;

    public String getWorkDataCode() {
        return workDataCode;
    }

    public void setWorkDataCode(String workDataCode) {
        this.workDataCode = workDataCode;
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

    public List<WorkDataRecordDTO> getWorkDataRecordDTOS() {
        return workDataRecordDTOS;
    }

    public void setWorkDataRecordDTOS(List<WorkDataRecordDTO> workDataRecordDTOS) {
        this.workDataRecordDTOS = workDataRecordDTOS;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void addWorkRecord(WorkDataRecordDTO workDataRecordDTO) {
        if(CollectionUtils.isEmpty(workDataRecordDTOS)) {
            workDataRecordDTOS = new ArrayList<>();
        }
        workDataRecordDTOS.add(workDataRecordDTO);
    }

    public List<WorkDataDetailDTO> getWorkDataDetailDTOS() {
        return workDataDetailDTOS;
    }

    public void setWorkDataDetailDTOS(List<WorkDataDetailDTO> workDataDetailDTOS) {
        this.workDataDetailDTOS = workDataDetailDTOS;
    }

    public DataStatus getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(DataStatus dataStatus) {
        this.dataStatus = dataStatus;
    }

    public static WorkDataDTO mockWorkDataDTO() {
        WorkDataDTO workDataDTO = new WorkDataDTO();
        Date now = new Date(System.currentTimeMillis());
        workDataDTO.setWorkDataCode(UUID.randomUUID().toString());
        workDataDTO.setCreateDate(now);
        workDataDTO.setUpdateDate(now);
        workDataDTO.setStartDate(now);
        workDataDTO.setEndDate(now);
        workDataDTO.setWorkName("测试数据");
        workDataDTO.setWorkStatus(WorkStatus.WAITE);
        workDataDTO.setWorkDataCode(UUID.randomUUID().toString());
        workDataDTO.setWorkDataDetailDTOS(WorkDataDetailDTO.mockData(workDataDTO.getWorkDataCode()));
        return workDataDTO;
    }
}
