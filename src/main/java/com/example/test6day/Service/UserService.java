package com.example.test6day.Service;

import com.example.test6day.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 注册用户
     */
    public void registUser(User user);
    /**
     * 登录
     */
    public List<User> login(User user);
    /**
     * 检查 用户名是否可用
     */
    public boolean existUsername(String username);
}
