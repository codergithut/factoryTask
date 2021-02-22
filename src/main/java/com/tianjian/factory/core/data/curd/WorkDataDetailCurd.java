package com.tianjian.factory.core.data.curd;

import com.tianjian.factory.core.data.WorkDataDetailEo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tianjian on 2021/2/8.
 */
public interface WorkDataDetailCurd extends CrudRepository<WorkDataDetailEo, String> {
    List<WorkDataDetailEo> findByUserCode(String userCode);

    List<WorkDataDetailEo> findByWorkDataCode(String workDataCode);
}
