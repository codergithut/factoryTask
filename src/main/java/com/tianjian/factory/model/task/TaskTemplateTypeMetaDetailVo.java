package com.tianjian.factory.model.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class TaskTemplateTypeMetaDetailVo {
    /**
     * 数据key
     */
    @ApiModelProperty("数据key")
    private String metaName;

    /**
     * 数据类型
     */
    @ApiModelProperty("数据类型")
    private String metaType;

    /**
     * 是否必填
     */
    @ApiModelProperty("是否必填")
    private String isRequired;

    public String getMetaName() {
        return metaName;
    }

    public void setMetaName(String metaName) {
        this.metaName = metaName;
    }

    public String getMetaType() {
        return metaType;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
    }

    public String getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired;
    }
}
