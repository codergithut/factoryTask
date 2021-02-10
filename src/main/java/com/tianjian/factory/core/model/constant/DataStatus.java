package com.tianjian.factory.core.model.constant;

/**
 * Created by tianjian on 2021/2/8.
 */
public enum DataStatus {

    //完成 等待 进行中
    CREATE("CREATE"),UPDATE("UPDATE"),COMMON("COMMON");

    private String status;

    DataStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


}
