package com.example.test6day.Data;
import com.example.test6day.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;
import java.util.Map;

@ContextConfiguration("classpath:applicationContext.xml")
@Repository("JDBCtem")
public class JDBCtem {
    public JDBCtem() {
    }
    private static JdbcTemplate jdbcTemplate;
    static {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
    }
    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        JDBCtem.jdbcTemplate = jdbcTemplate;
    }

    //修改,增加，删除操作
    public int update(String sql, Object...orgs){
        return jdbcTemplate.update(sql, orgs);
    }
    //查询操作一条
    public Map<String, Object> queryForMap(String sql, Object...orgs){
       return  jdbcTemplate.queryForMap(sql,orgs);
    }
    //查询一组
    public <T> List<Map<String,Object>> queryForList(String sql,Class<T> tClass ,Object...org){
        return jdbcTemplate.queryForList(sql,org);
    }
    //查询总数
    public int queryCount(String sql){
        try {
            Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
            return integer;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //封装到javabean中
    public <T> List<T> queryBean(String sql,Class<T> tClass,Object...org){
      return  jdbcTemplate.query(sql,new BeanPropertyRowMapper<T>(tClass),org);
    }
}
