package com.treeinjar.service.serviceimpl;

import com.treeinjar.model.dao.User;
import com.treeinjar.model.mybatis.mapper.UserMapper;
import com.treeinjar.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cuiyingjia on 15/6/18.
 */
@Service
public class UserServiceimpl implements UserService{

    @Autowired
    UserMapper userMapper;

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(User record) {
        return 0;
    }

    public int insertSelective(User record) {
        return 0;
    }

    public User selectByPrimaryKey(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
