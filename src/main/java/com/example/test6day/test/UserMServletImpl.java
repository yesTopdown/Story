package com.example.test6day.test;

import com.example.test6day.Data.JDBCtem;
import com.example.test6day.Service.UserManageService;
import com.example.test6day.pojo.User;
import com.example.test6day.pojo.UserManage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMServletImpl {
    @Autowired
    JDBCtem jdbCtem;
    @Autowired
    UserManageService userManageSer;
    @Test
    public void queryUsername() {

    }
    @Test
    public void queryNamePass() {

    }
    @Test
    public void updateNePwPn() {
        userManageSer.addUser(new UserManage(null,"张三","1234@qq.com","12365478963","老师"));
    }
}
