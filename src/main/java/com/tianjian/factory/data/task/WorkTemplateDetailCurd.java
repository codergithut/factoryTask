package com.tianjian.factory.data.task;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface WorkTemplateDetailCurd extends CrudRepository<WorkTemplateDetailPo, String> {
    WorkTemplateDetailPo findByWorkTemplateIdAndOrderNum(String workTemplateId, int orderNum);

    List<WorkTemplateDetailPo> findByWorkTemplateId(String workTemplateId);
}
