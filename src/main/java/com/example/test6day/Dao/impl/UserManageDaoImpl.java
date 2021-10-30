package com.example.test6day.Dao.impl;

import com.example.test6day.Dao.UserManageDao;
import com.example.test6day.Data.JDBCtem;
import com.example.test6day.pojo.UserManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userManageDao")
public class UserManageDaoImpl implements UserManageDao {
    public UserManageDaoImpl() {
    }
    @Autowired
    JDBCtem jdbCtem;
    @Override
    public List<Map<String, Object>> queryUsername(String username) {
        String sql="select * from usermanage where username=?";
        return jdbCtem.queryForList(sql, UserManage.class,username);
    }

    @Override
    public List<UserManage> queryUser() {
        String sql="select * from usermanage";
        return jdbCtem.queryBean(sql,UserManage.class);

    }

    @Override
    public int updateUser(UserManage manage) {
        String sql="insert into usermanage(username,email,phoneNum,profession) value (?,?,?,?)";
        return jdbCtem.update(sql,manage.getUsername(),manage.getEmail(),manage.getPhoneNum(),manage.getProfession());
    }
    @Override
    public int deleteUser(UserManage manage){
        String sql="delete from usermanage where id=?";
        return jdbCtem.update(sql,manage.getId());
    }
}
