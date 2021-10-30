package com.example.test6day.Dao;

import com.example.test6day.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> queryUsername(String username);//查找姓名是否重复
    public List<User> queryNamePass(String username, String password);//查找用户是否查找
    public int updateNePwPn(User user);//注册保存

}
