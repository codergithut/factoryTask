package com.tianjian.factory.data.task;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskTemplateTypeMetaCurd extends CrudRepository<TaskTemplateTypeMetaPo, String> {
    List<TaskTemplateTypeMetaPo> findByTaskTemplateType(String taskTemplateType);
}
