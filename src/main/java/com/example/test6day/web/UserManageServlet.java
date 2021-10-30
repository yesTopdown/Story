package com.example.test6day.web;

import com.example.test6day.Service.UserManageService;
import com.example.test6day.pojo.UserManage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manage")
public class UserManageServlet {
    @Autowired
    UserManageService userManageService;
    @RequestMapping("show")
    public ModelAndView ShowManage(){
        ModelAndView modelAndView=new ModelAndView();
        List<UserManage> userManages = userManageService.showUser();
        modelAndView.addObject("Manages",userManages);
        modelAndView.setViewName("/pages/user-list");
        return modelAndView;
    }
    @RequestMapping("adduser")
    public ModelAndView addUserM(String username,String email,String phoneNum,String profession){
        ModelAndView modelAndView=new ModelAndView();
        if(username==null||email==null||phoneNum==null||profession==null){
            modelAndView.addObject("msg","不能为空");
            modelAndView.setViewName("/pages/user-add");
        }
        boolean b = userManageService.existUsername(username);
        if(b){
            modelAndView.addObject("msg","已有此用户");
            modelAndView.setViewName("/pages/user-add");
        }else {
            userManageService.addUser(new UserManage(null,username,email,phoneNum,profession));
            modelAndView.setViewName("forward:/manage/show");
        }
        return modelAndView;
    }

    @RequestMapping("exist")
    @ResponseBody
    public Map<String,Object> exist(String username) throws JsonProcessingException {
        System.out.println("okk");
        Map<String,Object> map=new HashMap<>();
        boolean b = userManageService.existUsername(username);
        if(!b){
            map.put("userExsit", true);
            map.put("msg", "此用户名已注册");
        }else {
            //不存在
            map.put("userExsit",false);
            map.put("msg","用户名可用");
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
            userManageService.deleteUser(id);
        }
        modelAndView.setViewName("redirect:/manage/show");
        return modelAndView;
    }
}
