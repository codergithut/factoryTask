package com.tianjian.factory.core.model;


import java.util.List;
import java.util.UUID;

/**
 * Created by tianjian on 2021/2/8.
 */

public class ResourceDTO {

    private String resourceCode;

    //当前数据编码
    private String workDataDetailCode;

    //工作请求编码
    private String workDataCode;

    //工作流程元数据
    List<ResourceMetaDTO> resourceMetaDTOS;

    //工作资源值
    private String resourceValue;

    //操作人
    private String userCode;

    //资源的MD5
    private String md5Code;

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

    public List<ResourceMetaDTO> getResourceMetaDTOS() {
        return resourceMetaDTOS;
    }

    public void setResourceMetaDTOS(List<ResourceMetaDTO> resourceMetaDTOS) {
        this.resourceMetaDTOS = resourceMetaDTOS;
    }

    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue;
    }

    public String getMd5Code() {
        return md5Code;
    }

    public void setMd5Code(String md5Code) {
        this.md5Code = md5Code;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public static ResourceDTO mockResource(String workDataCode, String workDataDetailCode) {
        ResourceDTO resourceDTO = new ResourceDTO();
        resourceDTO.setResourceCode(UUID.randomUUID().toString());
        resourceDTO.setWorkDataCode(workDataCode);
        resourceDTO.setWorkDataDetailCode(workDataDetailCode);
        resourceDTO.setResourceValue("我是测试资源数据哈哈哈哈");
        resourceDTO.setUserCode(UUID.randomUUID().toString());
        resourceDTO.setResourceMetaDTOS(ResourceMetaDTO.mockResourceMeta(workDataCode, workDataDetailCode));
        return resourceDTO;

    }
}
