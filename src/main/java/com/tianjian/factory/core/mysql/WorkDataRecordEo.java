package com.tianjian.factory.core.mysql;

import com.tianjian.factory.core.model.constant.WorkOperator;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tianjian on 2021/2/8.
 */
@Entity
public class WorkDataRecordEo {


    @Id
    private String workDataRecordCode;

    //工作编码
    private String workDataCode;

    //操作记录
    private WorkOperator workOperator;

    //工作细节编码
    private String workDataDetailCode;

    //处理人编码
    private String userCode;

    public String getWorkDataCode() {
        return workDataCode;
    }

    public void setWorkDataCode(String workDataCode) {
        this.workDataCode = workDataCode;
    }

    public WorkOperator getWorkOperator() {
        return workOperator;
    }

    public void setWorkOperator(WorkOperator workOperator) {
        this.workOperator = workOperator;
    }

    public String getWorkDataDetailCode() {
        return workDataDetailCode;
    }

    public void setWorkDataDetailCode(String workDataDetailCode) {
        this.workDataDetailCode = workDataDetailCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getWorkDataRecordCode() {
        return workDataRecordCode;
    }

    public void setWorkDataRecordCode(String workDataRecordCode) {
        this.workDataRecordCode = workDataRecordCode;
    }
}
