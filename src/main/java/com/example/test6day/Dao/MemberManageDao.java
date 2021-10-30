package com.example.test6day.Dao;

import com.example.test6day.pojo.Member;
import java.util.List;
import java.util.Map;

public interface MemberManageDao {
    public List<Map<String, Object>> queryUsername(String username);//查找是否已经有用户
    public List<Member> queryMember();//查找全部用户
    public int updateUser(Member member);//注册保存
    public int deleteUser(Member member);//删除用户
}
