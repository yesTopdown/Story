package com.example.test6day.test;

import com.example.test6day.Data.JDBCtem;
import com.example.test6day.pojo.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JDBCtemTest extends TestCase {
    @Autowired
    JDBCtem jdbCtem;
    @Test
    public void testUpdate() {
        String sql="insert into user(username,password,phoneNum) value(?,?,?)";
        System.out.println(jdbCtem.update(sql, "小明", "123456","147852369321"));
    }
    @Test
    public void testQueryForMap() {
        String sql="select * from user where username=?";
        Map<String, Object> i= jdbCtem.queryForMap(sql, "张三");
        System.out.println(i);

    }
    @Test
    public void testQueryForList() {
        String sql="select * from user";
        List<Map<String, Object>> maps = jdbCtem.queryForList(sql, User.class);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
    @Test
    public void testQueryCount() {
        String sql="select count(*) from user";
        int i = jdbCtem.queryCount(sql);
        System.out.println(i);
    }
    @Test
    public void testQueryBean() {
        String sql="select * from user where username=?";
        List<User> users = jdbCtem.queryBean(sql, User.class,"张三");
        System.out.println(users);
    }
}