package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JdbcTemplateTest {
    //类名  对象名 = null ; 定义一个成员变量，可以被所有方法访问
    JdbcTemplate jdbcTemplate = null;
    @Before
    public void init() throws Exception {
        System.out.println("----init-----");
        //1:创建jdbcTemplate
        jdbcTemplate = new JdbcTemplate();

        //2:设置druid
        jdbcTemplate.setDataSource(getDruidDataSource());

    }
    @Test
    public void test01Druid() throws Exception {
        System.out.println("----test01Druid-----");
        //3:调 update 添加，删除，修改 ,query 查询
        jdbcTemplate.update("delete from tab_user where uid = ?",2);//参1，sql语句，参2 参数
    }

    @Test
    public void test02Insert(){
        System.out.println("---test02");
        jdbcTemplate.update("INSERT INTO tab_user  (uid,username,`password`)VALUES(?,?,?);",1003L,"tony","456");
    }
    @Test
    public void test03update(){
        System.out.println("---test03");
        jdbcTemplate.update("UPDATE tab_user SET username = ?,`password` = ? WHERE uid =?","baoqiang","1234",1003L);
    }
    private DataSource getDruidDataSource() throws Exception {
        //1:读配置文件
        InputStream inputStream = DruidTest.class.getResourceAsStream("/druid.properties");
        Properties properties = new Properties();//用于读.properties的文件
        properties.load(inputStream);
        System.out.println(properties.getProperty("druid.username"));
        //2:设置给Druid 对象
        DruidDataSource source = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);//使用properties数据创建连接池
        return source;
    }

}
