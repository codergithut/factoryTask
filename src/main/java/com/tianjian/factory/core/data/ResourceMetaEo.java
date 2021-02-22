package com.tianjian.factory.core.data;

import com.tianjian.factory.core.model.constant.Constraints;
import com.tianjian.factory.core.model.constant.Metadata;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tianjian on 2021/2/8.
 */
@Entity
public class ResourceMetaEo {

    //资源模型编码
    @Id
    private String resourceMetaCode;

    //当前数据编码
    private String workDataDetailCode;

    //工作请求编码
    private String workDataCode;

    //约束条件
    private Constraints constraints;

    //元数据类型
    private Metadata metadata;

    private String isDelete;

    public String getResourceMetaCode() {
        return resourceMetaCode;
    }

    public void setResourceMetaCode(String resourceMetaCode) {
        this.resourceMetaCode = resourceMetaCode;
    }

    public Constraints getConstraints() {
        return constraints;
    }

    public void setConstraints(Constraints constraints) {
        this.constraints = constraints;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

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
}
