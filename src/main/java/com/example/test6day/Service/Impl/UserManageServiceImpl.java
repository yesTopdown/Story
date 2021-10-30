package com.example.test6day.Service.Impl;

import com.example.test6day.Dao.UserManageDao;
import com.example.test6day.Service.UserManageService;
import com.example.test6day.pojo.UserManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userManageService")
public class UserManageServiceImpl implements UserManageService {
    public UserManageServiceImpl() {
    }
    @Autowired
    UserManageDao userManageDao;
    @Override
    public void addUser(UserManage manage) {
        userManageDao.updateUser(manage);
    }

    @Override
    public List<UserManage> showUser() {
        List<UserManage> userManages = userManageDao.queryUser();
        return userManages;
    }

    @Override
    public boolean existUsername(String username) {
        List<Map<String, Object>> maps = userManageDao.queryUsername(username);
        return maps==null;
    }

    @Override
    public void deleteUser(Integer id) {
        userManageDao.deleteUser(new UserManage(id,null,null,null,null));
    }
}
