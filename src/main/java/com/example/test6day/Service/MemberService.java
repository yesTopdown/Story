package com.example.test6day.Service;

import com.example.test6day.pojo.Member;

import java.util.List;

public interface MemberService {
    /**
     * 添加用户
     */
    public void addMember(Member member);
    /**
     * 全部用户
     */
    public List<Member> showMember();
    /**
     * 检查 用户名是否重复
     */
    public boolean existUsername(String username);
    /**
     * 删除某人
     */
    public void deleteUser(Integer id);
}
