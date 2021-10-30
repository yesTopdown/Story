package com.example.test6day.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component("StoryAspect")
@Aspect
public class StoryMapperAspect {
    private StoryMapper storyMapper;

    //定义切点表达式
    @Pointcut("execution(* com.example.test6day.mapper.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        storyMapper=sqlSession.getMapper(StoryMapper.class);
    }

}
