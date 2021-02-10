package com.tianjian.factory.core.model.constant;

/**
 * Created by tianjian on 2021/2/8.
 */
public enum WorkStatus {

    //完成 等待 进行中
    DONE("DONE"),WAITE("WAITE"),DOING("DOING");

    private String status;

    WorkStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


}
