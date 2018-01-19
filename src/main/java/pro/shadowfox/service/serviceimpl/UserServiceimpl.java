package pro.shadowfox.service.serviceimpl;

import pro.shadowfox.model.vo.dao.User;
import pro.shadowfox.model.mapper.UserMapper;
import pro.shadowfox.service.UserService;
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
