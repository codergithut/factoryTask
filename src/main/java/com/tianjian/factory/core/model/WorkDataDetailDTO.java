package com.tianjian.factory.core.model;

import com.tianjian.factory.core.model.constant.WorkStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.tianjian.factory.core.model.constant.WorkStatus.WAITE;

/**
 * Created by tianjian on 2021/2/8.
 */
public class WorkDataDetailDTO {

    private String workDataCode;

    //当前数据编码
    private String workDataDetailCode;

    //处理人员信息
    private UserInfoDTO handleUserInfo;

    //当前任务资源信息
    private ResourceDTO resourceDTO;

    //任务开始时间
    private Date startDate;

    //任务结束时间
    private Date endDate;

    //当前开启的新任务
    private WorkDataDTO workDataDTO;

    private WorkStatus workStatus;

    private Integer sortNum;

    private Integer totalNum;

    public String getWorkDataDetailCode() {
        return workDataDetailCode;
    }

    public void setWorkDataDetailCode(String workDataDetailCode) {
        this.workDataDetailCode = workDataDetailCode;
    }

    public UserInfoDTO getHandleUserInfo() {
        return handleUserInfo;
    }

    public void setHandleUserInfo(UserInfoDTO handleUserInfo) {
        this.handleUserInfo = handleUserInfo;
    }

    public ResourceDTO getResourceDTO() {
        return resourceDTO;
    }

    public void setResourceDTO(ResourceDTO resourceDTO) {
        this.resourceDTO = resourceDTO;
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

    public WorkDataDTO getWorkDataDTO() {
        return workDataDTO;
    }

    public void setWorkDataDTO(WorkDataDTO workDataDTO) {
        this.workDataDTO = workDataDTO;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getWorkDataCode() {
        return workDataCode;
    }

    public void setWorkDataCode(String workDataCode) {
        this.workDataCode = workDataCode;
    }

    public static List<WorkDataDetailDTO> mockData(String workDataCode) {
        List<WorkDataDetailDTO> datas = new ArrayList<>();
        Date now = new Date(System.currentTimeMillis());
        for(int i = 0; i < 3; i++) {
            WorkDataDetailDTO workDataDetailDTO = new WorkDataDetailDTO();
            workDataDetailDTO.setWorkDataCode(workDataCode);
            workDataDetailDTO.setWorkDataDetailCode(UUID.randomUUID().toString());
            workDataDetailDTO.setWorkStatus(WAITE);
            workDataDetailDTO.setSortNum(i);
            workDataDetailDTO.setTotalNum(2);
            workDataDetailDTO.setEndDate(now);
            workDataDetailDTO.setStartDate(now);
            workDataDetailDTO.setHandleUserInfo(UserInfoDTO.mockData());
            workDataDetailDTO.setResourceDTO(ResourceDTO.mockResource(workDataCode, workDataDetailDTO.getWorkDataDetailCode()));
            datas.add(workDataDetailDTO);
        }
        return datas;
    }
}
