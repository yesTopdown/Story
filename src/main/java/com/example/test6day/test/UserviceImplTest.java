package com.example.test6day.test;

import com.example.test6day.Dao.UserDao;
import com.example.test6day.Service.UserService;
import com.example.test6day.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserviceImplTest {
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
    @Test
    public void queryUsername() {
//        Map<String, Object> ab = userDao.queryUsername("张三");
//        System.out.println(ab);
        boolean abc = userService.existUsername("abc");
        System.out.println(abc);
    }
    @Test
    public void queryNamePass() {
//        List<User> users = userDao.queryNamePass("小明", "123456");
//        System.out.println(users);
        List<User> xx = userService.login(new User(null, "xx", "123456", null));
        System.out.println(xx.isEmpty());
    }
    @Test
    public void updateNePwPn() {
//        int nePwPn = userDao.updateNePwPn(new User(null, "小红", "456789", "14785296325"));
//        System.out.println(nePwPn);
        userService.registUser(new User(null, "任我行", "456789", "14785296325"));
    }
}
