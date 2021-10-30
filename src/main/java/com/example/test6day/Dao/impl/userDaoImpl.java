package com.example.test6day.Dao.impl;

import com.example.test6day.Dao.UserDao;
import com.example.test6day.Data.JDBCtem;
import com.example.test6day.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userDao")
public class userDaoImpl implements UserDao {
    public userDaoImpl() {
    }
    @Autowired
    JDBCtem jdbCtem;

    public JDBCtem getJdbCtem() {
        return jdbCtem;
    }

    public void setJdbCtem(JDBCtem jdbCtem) {
        this.jdbCtem = jdbCtem;
    }

    @Override
    public List<User> queryUsername(String username) {
        String sql="select * from user where username=?";
        List<User> users = jdbCtem.queryBean(sql, User.class,username);
        return users;
//        String sql="select * from user where username=?";
//        return jdbCtem.queryForList(sql,User.class,username);
    }

    @Override
    public List<User> queryNamePass(String username, String password) {
        String sql="select * from user where username=? and password=?";
        return jdbCtem.queryBean(sql,User.class,username,password);
    }

    @Override
    public int updateNePwPn(User user) {
        String sql="insert into user(username,password,phoneNum) value (?,?,?)";
        return jdbCtem.update(sql,user.getUsername(),user.getPassword(),user.getPhoneNum());
    }
}
