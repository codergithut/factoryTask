package com.tianjian.factory.model.common;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RestModel<T> {

    @ApiModelProperty("返回编码")
    private String code;

    @ApiModelProperty("返回值")
    private T data;

    @ApiModelProperty("返回消息")
    private String msg;

    public RestModel(String code, T data, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestModel() {
    }

    public RestModel(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static <T> RestModel<T> success(T data) {
        RestModel<T> restModel = new RestModel<T>();
        restModel.setData(data);
        restModel.setCode("0000");
        restModel.setMsg("success");
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
