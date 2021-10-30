package com.example.test6day.web;

import com.example.test6day.Service.UserService;
import com.example.test6day.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserServlet {
    @Autowired
    UserService userService;
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(String username, String password, HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
        List<User> login = userService.login(new User(null, username, password, null));
        if(login.isEmpty()){
            modelAndView.addObject("msg","用户名和密码错误");
            modelAndView.addObject("username",username);
            modelAndView.setViewName("/login");
        }else {
            modelAndView.addObject("user",login.remove(0));
           // session.setAttribute("login",login);
            modelAndView.setViewName("redirect:/user/main");
        }
        return modelAndView;
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("register")
    public ModelAndView regist(String username,String password,String phoneNum){
        ModelAndView modelAndView=new ModelAndView();
        boolean b = userService.existUsername(username);
        System.out.println(b);
        if(!b){
            modelAndView.addObject("msg","用户名已经存在");
            modelAndView.setViewName("/regist");
        }
        else {
            userService.registUser(new User(null,username,password,phoneNum));
            modelAndView.setViewName("/login");
        }
        return modelAndView;
    }

    @RequestMapping("main")
    public ModelAndView Main() throws IOException {
        //加载核心配置文件
        InputStream resourceInput=  Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceInput);
        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        List<User> list = sqlSession.selectList("userMapper.findAll");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("users",list);
        modelAndView.setViewName("/pages/main");
        return modelAndView;
    }

    @RequestMapping(value = "exist" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> exist(@RequestBody String username) throws JsonProcessingException {
        Map<String,Object> map=new HashMap<>();
        boolean b = userService.existUsername(username);
        System.out.println(b);
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

    @RequestMapping("/cancel")
    public ModelAndView cancel(HttpServletRequest request){
        request.getSession().invalidate();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/login.jsp");
        return modelAndView;
    }
}
