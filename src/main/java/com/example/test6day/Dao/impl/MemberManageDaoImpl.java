package com.example.test6day.Dao.impl;

import com.example.test6day.Dao.MemberManageDao;
import com.example.test6day.Data.JDBCtem;
import com.example.test6day.pojo.Member;
import com.example.test6day.pojo.UserManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("memberManageDao")
public class MemberManageDaoImpl implements MemberManageDao {
    public MemberManageDaoImpl() {
    }
    @Autowired
    JDBCtem jdbCtem;
    @Override
    public List<Map<String, Object>> queryUsername(String username) {
        String sql="select * from membermanage where username=?";
        return jdbCtem.queryForList(sql, Member.class,username);
    }

    @Override
    public List<Member> queryMember() {
        String sql="select * from membermanage";
        return jdbCtem.queryBean(sql,Member.class);
    }

    @Override
    public int updateUser(Member member) {
        String sql="insert into membermanage(username,profession,time) value (?,?,?)";
        return jdbCtem.update(sql,member.getUsername(),member.getProfession(),member.getTime());
    }

    @Override
    public int deleteUser(Member member) {
        String sql="delete from membermanage where id=?";
        return jdbCtem.update(sql,member.getId());
    }
}
