package com.example.test6day.Dao;


import com.example.test6day.pojo.UserManage;

import java.util.List;
import java.util.Map;

public interface UserManageDao {
    public List<Map<String, Object>> queryUsername(String username);//查找是否已经有用户
    public List<UserManage> queryUser();//查找全部用户
    public int updateUser(UserManage manage);//注册保存
    public int deleteUser(UserManage manage);//删除用户
}
