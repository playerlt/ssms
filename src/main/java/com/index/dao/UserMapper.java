package com.index.dao;

import com.index.pojo.User;

/**
 * @author index
 * @date 2020/11/12
 **/
public interface UserMapper {
    User getByNo(String no);
}
