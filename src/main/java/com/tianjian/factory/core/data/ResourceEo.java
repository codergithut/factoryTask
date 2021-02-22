package com.tianjian.factory.core.data;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tianjian on 2021/2/8.
 */
@Entity
public class ResourceEo {


    @Id
    private String resourceCode;


    //当前数据编码
    private String workDataDetailCode;

    //工作请求编码
    private String workDataCode;

    //工作流程元数据
    private String resourceMetaCodes;

    //工作资源值
    private String resourceValue;

    //操作人
    private String userCode;


    public String getWorkDataDetailCode() {
        return workDataDetailCode;
    }

    public void setWorkDataDetailCode(String workDataDetailCode) {
        this.workDataDetailCode = workDataDetailCode;
    }

    public String getWorkDataCode() {
        return workDataCode;
    }

    public void setWorkDataCode(String workDataCode) {
        this.workDataCode = workDataCode;
    }

    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getResourceMetaCodes() {
        return resourceMetaCodes;
    }

    public void setResourceMetaCodes(String resourceMetaCodes) {
        this.resourceMetaCodes = resourceMetaCodes;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }



}
