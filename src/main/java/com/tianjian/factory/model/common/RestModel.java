package com.tianjian.factory.model.common;

public class RestModel {
    private String code;

    private Object data;

    private String message;

    public RestModel(String code, String desc, Object data) {
        this.code = code;
        this.message = desc;
        this.data = data;
    }

    public RestModel() {
    }

    public RestModel(String code, String desc) {
        this.code = code;
        this.message = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static RestModel success(Object data) {
        RestModel restModel = null;
        if(data != null) {
            restModel = new RestModel("000000", "success", data);
        } else {
            restModel = new RestModel("000000", "success");
        }

        return restModel;
    }

    public static RestModel success() {
        return success(null);
    }

    public static RestModel fail(String code, String message) {
        RestModel restModel = new RestModel(code, message);
        return restModel;
    }
}
