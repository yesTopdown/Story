package com.example.test6day.Service.Impl;

import com.example.test6day.Dao.MemberManageDao;
import com.example.test6day.Service.MemberService;
import com.example.test6day.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
    public MemberServiceImpl() {
    }
    @Autowired
    MemberManageDao memberManageDao;
    @Override
    public void addMember(Member member) {
        memberManageDao.updateUser(member);
    }

    @Override
    public List<Member> showMember() {
        List<Member> members = memberManageDao.queryMember();
        return members;
    }

    @Override
    public boolean existUsername(String username) {
        List<Map<String, Object>> maps = memberManageDao.queryUsername(username);
        return maps==null;
    }

    @Override
    public void deleteUser(Integer id) {
        memberManageDao.deleteUser(new Member(id,null,null,null));
    }
}
