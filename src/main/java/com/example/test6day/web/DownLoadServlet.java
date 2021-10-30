package com.example.test6day.web;

import com.example.test6day.mapper.StoryMapper;
import com.example.test6day.pojo.Story;
import com.example.test6day.pojo.Storyfile;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/File")
public class DownLoadServlet {

    private static StoryMapper storyMapper;
    private static ArrayList<Storyfile> sf=new ArrayList<>();
    static  {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        storyMapper=sqlSession.getMapper(StoryMapper.class);
    }
    @RequestMapping("upload")
    public ModelAndView upload(String username, MultipartFile uploadFile, String content,String[] answer,HttpServletRequest request) throws IOException {
        String path = "D:\\IdeaJavaweb\\Story\\src\\main\\webapp\\source\\";
        //获取文件的名称
        String filename = uploadFile.getOriginalFilename();
       // path = request.getSession().getServletContext().getRealPath("/");
        //保存文件
        uploadFile.transferTo(new File(path +filename));
        Story story=new Story(null,username,path+filename,content,answer[0]);
        storyMapper.save(story);
        sf.add(new Storyfile(story,answer));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/File/show");
        return modelAndView;
    }
    @RequestMapping("showStory")
    public ModelAndView showStory(){
        ModelAndView modelAndView=new ModelAndView();
        for (Storyfile storyfile : sf) {
            System.out.println(storyfile);
        }
        modelAndView.addObject("sft",sf);
        modelAndView.setViewName("/pages/syslog-list");
        return modelAndView;
    }

    @RequestMapping("show")
    public ModelAndView show(){
        ModelAndView modelAndView=new ModelAndView();
        List<Story> stories = storyMapper.storyList();
        modelAndView.addObject("storyList",stories);
        Integer count = storyMapper.countStory();
        System.out.println(count);
        modelAndView.addObject("count",count);
        modelAndView.setViewName("/pages/social-event");
        return modelAndView;
    }

    @RequestMapping("delete")
    public ModelAndView delete(Integer id){
        ModelAndView modelAndView=new ModelAndView();
        if(id!=null) {
            storyMapper.delete(id);
        }
        modelAndView.setViewName("redirect:/File/show");
        return modelAndView;
    }
    @RequestMapping("display")
    public ModelAndView display(Integer id) throws IOException {
        System.out.println(id);
        ModelAndView modelAndView=new ModelAndView();
        Storyfile storyfile = sf.get(id);
        modelAndView.addObject("storyfile",storyfile);
        modelAndView.setViewName("/pages/show-event");
        return modelAndView;
    }
    @RequestMapping("showAssess")
    public ModelAndView modelView(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("sfs",sf);
        modelAndView.setViewName("/pages/study-assess");
        return modelAndView;
    }
    @RequestMapping("assess")
    public ModelAndView modelViewAss(String[] val){
        ModelAndView modelAndView=new ModelAndView();
        String[] storyanswer = storyMapper.Storyanswer();
        int count=0;
        double scoreaver=100.0/storyanswer.length;
        for (String s : storyanswer) {
            for (String s1 : val) {
                if(s.equals(s1)){
                    count++;
                }
            }
        }
        double score=scoreaver*count;
        modelAndView.addObject("score",score);
        modelAndView.setViewName("/pages/study-assess");
        return modelAndView;
    }
}
