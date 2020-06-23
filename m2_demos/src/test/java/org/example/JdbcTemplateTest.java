package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JdbcTemplateTest {
    @Test
    public void test01Druid() throws Exception {

        //1:创建jdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        //2:设置druid
        jdbcTemplate.setDataSource(getDruidDataSource());

        //3:调 update 添加，删除，修改 ,query 查询
        jdbcTemplate.update("delete from tab_user where uid = ?",2);//参1，sql语句，参2 参数
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
