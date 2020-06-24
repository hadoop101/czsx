package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.example.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Test
    public void test04select(){
        System.out.println("---test04");
        //1:编写 sql查询语句 SELECT * FROM tab_user WHERE uid = 1003;
        //2:定义一个实体类，有10个变量，名字要跟列名一样。
        //3:调用query
        String sql = "SELECT * FROM tab_user WHERE uid = ?";
        //查询一条记录，将该记录保存在一个对象的成员变量里面
        //参1：是sql语句  参2：转换规则 参3：数值
        RowMapper<User> mapper = new RowMapper<User>() {
            //结果集表示的是查询的结果
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                //作映射或者叫对应
                User user = new User();
                user.setUid(resultSet.getLong("uid"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                //还有7个值与变量需要对应
                return user;
            }


        };
        User user=jdbcTemplate.queryForObject(sql,mapper,1001L);
        System.out.println(user);

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
