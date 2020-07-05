package com.tianjian.factory.data.task;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskInsDataCurd extends CrudRepository<TaskInsDataPo, String> {
    List<TaskInsDataPo> findByWorkTemplateId(String workTemplateId);

    TaskInsDataPo findByWorkTemplateIdAndTaskStatus(String workTemplateId, String wait);

    TaskInsDataPo findByWorkTemplateIdAndTaskTemplateId(String workTemplateId, String taskTemplateId);
}
