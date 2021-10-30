package com.example.test6day.Service.Impl;

import com.example.test6day.Dao.UserDao;
import com.example.test6day.Service.UserService;
import com.example.test6day.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
    }
    @Autowired
    UserDao userDao;
    //注册
    @Override
    public void registUser(User user) {
        userDao.updateNePwPn(user);
    }
    //登录
    @Override
    public List<User> login(User user) {
        List<User> users = userDao.queryNamePass(user.getUsername(), user.getPassword());
        return users;
    }
    //检查用户名是否可用
    @Override
    public boolean existUsername(String username) {
        List<User> maps = userDao.queryUsername(username);
        System.out.println(maps);
        return maps.isEmpty();
    }
}
