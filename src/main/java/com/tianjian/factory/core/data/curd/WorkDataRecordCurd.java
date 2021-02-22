package com.tianjian.factory.core.data.curd;

import com.tianjian.factory.core.data.WorkDataRecordEo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tianjian on 2021/2/8.
 */
public interface WorkDataRecordCurd extends CrudRepository<WorkDataRecordEo, String> {
    List<WorkDataRecordEo> findByWorkDataCode(String workDataCode);
}
