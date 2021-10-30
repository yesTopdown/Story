package com.example.test6day.Service;

import com.example.test6day.pojo.UserManage;

import java.util.List;

public interface UserManageService {
    /**
     * 添加会员
     */
    public void addUser(UserManage manage);
    /**
     * 全部会员
     */
    public List<UserManage> showUser();
    /**
     * 检查 会员名是否重复
     */
    public boolean existUsername(String username);
    /**
     * 删除会员
     */
    public void deleteUser(Integer id);
}
