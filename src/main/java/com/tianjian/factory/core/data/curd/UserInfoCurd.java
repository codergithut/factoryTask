package com.tianjian.factory.core.data.curd;

import com.tianjian.factory.core.data.UserInfoEo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tianjian on 2021/2/8.
 */
public interface UserInfoCurd extends CrudRepository<UserInfoEo, String> {
    UserInfoEo findByUserCode(String userCode);
}
