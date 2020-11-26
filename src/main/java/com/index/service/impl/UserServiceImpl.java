package com.index.service.impl;

import com.index.dao.UserMapper;
import com.index.pojo.User;
import com.index.service.UserService;
import com.index.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author index
 * @date 2020/11/12
 **/
public class UserServiceImpl implements UserService {

    @Override
    public User getByNo(String no) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getByNo(no);
//        System.out.println(user);
        sqlSession.close();
        return user;
    }
}
