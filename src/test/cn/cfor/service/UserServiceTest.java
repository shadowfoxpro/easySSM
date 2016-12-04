package cn.cfor.service;

import cn.cfor.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration("classpath:spring*.xml")
public class UserServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    public void HelloTest(){

        userService.selectByPrimaryKey(1);
        userMapper.selectByPrimaryKey(1);

    }

}