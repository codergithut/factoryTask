package com.tianjian.factory.core.data.curd;

import com.tianjian.factory.core.data.WorkDataEo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tianjian on 2021/2/8.
 */
public interface WorkDataCurd extends CrudRepository<WorkDataEo, String> {
    WorkDataEo findAllByWorkDataCode(String workDataCode);
}
