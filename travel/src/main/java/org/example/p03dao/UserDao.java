package org.example.p03dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

//dao层，数据访问层，通常有方法saveXxx  updateXxx deleteXxx findXxx
public class UserDao {
    public int findByUserNamePassword(String username, String password) throws Exception {
        //..查询数据库
        //1:编写查询sql
        String sql = "SELECT count(*) FROM tab_user WHERE username= ? AND `password`=?";
        //2:交给query
        //2.1:JdbcTemplate+数据源 依赖 在 pom.xml文件里面添加jdbc,druid,jdbctemplate
        //2.2:配置在resources目录添加druid.properties 配置账号密码主机端口
        //2.3:数据源
        DataSource dataSource = getDruidDataSource();
        //2.4:模板对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        //2.5:调查询
        Object[] args ={username,password};
        Integer count =  jdbcTemplate.queryForObject(sql, args,Integer.class);//参1sql参2数据参3返回结果的类型
        return count;
    }
    //3:优化，只需要创建一个数据源
    private static DataSource dataSource = null;
    private  DataSource getDruidDataSource() throws Exception {
        if(dataSource  == null){
            //1:读配置文件
            InputStream inputStream = UserDao.class.getResourceAsStream("/druid.properties");
            Properties properties = new Properties();//用于读.properties的文件
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);//使用properties数据创建连接池
        }
        return dataSource;
    }
}
