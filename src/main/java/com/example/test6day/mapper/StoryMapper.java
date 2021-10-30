package com.example.test6day.mapper;

import com.example.test6day.pojo.Story;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StoryMapper {

    @Select("select * from story")
    public List<Story> storyList();

    @Select("select * from story where id=#{id}")
    public Story queryById(Integer id);

    @Insert("insert into story values(#{id},#{name},#{path},#{content},#{answer})")
    public void save(Story story);

    @Update("update story set name=#{name},path=#{path} where id=#{id}")
    public void update(Story story);

    @Delete("delete from story where id=#{id}")
    public boolean delete(Integer id);

    @Select("select count(*) from story")
    public Integer countStory();
    @Select("select answer from story")
    public String[] Storyanswer();
}
