package com.example.test6day.web;

import com.example.test6day.Service.MemberService;
import com.example.test6day.pojo.Member;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("member")
public class MemberServlet {
    @Autowired
    MemberService memberService;
    @RequestMapping("show")
    public ModelAndView ShowManage(){
        ModelAndView modelAndView=new ModelAndView();
        List<Member> members = memberService.showMember();
        modelAndView.addObject("members",members);
        modelAndView.setViewName("/pages/role-list");
        return modelAndView;
    }
    @RequestMapping("adduser")
    public ModelAndView addUserM(String username,String profession){
        ModelAndView modelAndView=new ModelAndView();
        if(username==null||profession==null){
            modelAndView.addObject("msg","不能为空");
            modelAndView.setViewName("/pages/role-add");
        }
        boolean b = memberService.existUsername(username);
        if(b){
            modelAndView.addObject("msg","已有会员");
            modelAndView.setViewName("/pages/role-add");
        }else {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd天");
            Date date =new Date();
            String time= sdf.format(date);
            memberService.addMember(new Member(null,username,profession,time));
            modelAndView.setViewName("forward:/member/show");
        }
        return modelAndView;
    }

    @RequestMapping("exist")
    @ResponseBody
    public Map<String,Object> exist(String username) throws JsonProcessingException {
        System.out.println("okk");
        Map<String,Object> map=new HashMap<>();
        boolean b = memberService.existUsername(username);
        if(!b){
            map.put("userExsit", true);
            map.put("msg", "已有会员");
        }else {
            //不存在
            map.put("userExsit",false);
            map.put("msg","会员可用");
        }
        return map;
    }
    /**
     * 删除某人
     */
    @RequestMapping("delete")
    public ModelAndView deleteManage(Integer id){
        ModelAndView modelAndView=new ModelAndView();
        if(id!=null) {
            memberService.deleteUser(id);
        }
        modelAndView.setViewName("redirect:/member/show");
        return modelAndView;
    }
}
