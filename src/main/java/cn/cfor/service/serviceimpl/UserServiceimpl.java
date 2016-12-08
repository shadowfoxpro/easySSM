package cn.cfor.service.serviceimpl;

import cn.cfor.model.vo.dao.User;
import cn.cfor.model.mapper.UserMapper;
import cn.cfor.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceimpl implements UserService{

    @Resource
    private UserMapper userMapper;

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
