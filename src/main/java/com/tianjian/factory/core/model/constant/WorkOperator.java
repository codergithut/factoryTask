package com.tianjian.factory.core.model.constant;

/**
 * Created by tianjian on 2021/2/8.
 */
public enum WorkOperator {
    //驳回 通过
    REJECT("REJECT"), PASS("PASS"), CHANGERESOURCE("CHANGERESOURCE"), CREATEWORK("CREATEWORK"), STARTWORK("STARTWORK");

    private String operatorName;

    WorkOperator(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorName(String operatorName) {
        return operatorName;
    }
}
