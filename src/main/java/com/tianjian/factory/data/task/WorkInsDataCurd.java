package com.tianjian.factory.data.task;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkInsDataCurd extends CrudRepository<WorkInsDataPo, String> {
    List<WorkInsDataPo> findByWorkTemplateId(String workTemplateId);

    List<WorkInsDataPo> findByHanderUserIdAndWorkStatus(String userId, String wait);

    List<WorkInsDataPo> findByHanderUserId(String userId);

    WorkInsDataPo findByWorkTemplateIdAndWorkStatus(String workTemplateId, String active);

    WorkInsDataPo findByWorkTemplateIdAndWorkStatusNot(String workTemplateId, String reject);
}
