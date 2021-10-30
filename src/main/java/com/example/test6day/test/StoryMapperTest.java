package com.example.test6day.test;

import com.example.test6day.mapper.StoryMapper;
import com.example.test6day.pojo.Story;
import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class StoryMapperTest {

    private StoryMapper storyMapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        storyMapper=sqlSession.getMapper(StoryMapper.class);
    }
    @Test
    public void testSave(){
        Story story=new Story();
        story.setId(1);
        story.setName("story1");
        story.setPath("story1");
        storyMapper.save(story);
    }

    @Test
    public void testAll(){
        List<Story> stories = storyMapper.storyList();
        for (Story s : stories){
            System.out.println(s);
        }
    }

    @Test
    public void testA() throws IOException {
        Reader rd=new FileReader(new File("D:\\IdeaJavaweb\\test6day\\src\\main\\resources\\source\\1.txt "));
        BufferedReader bf=new BufferedReader(rd);
        String line;
        while((line=bf.readLine())!=null){
            System.out.println(line);
        }
    }
}
