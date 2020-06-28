package org.example.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

//数据源与模板对象的工具类
public class JdbcTemplateUtil {
    /**
     * 获取模板对象
     * @return
     * @throws Exception
     */
    public static JdbcTemplate getJdbcTemplate() throws Exception {
        //获取数据源
        DataSource dataSource = getDruidDataSource();
        //创建模板对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源
        jdbcTemplate.setDataSource(dataSource);
        //返回模板对象
        return jdbcTemplate;
    }
    private static DataSource dataSource = null;

    /**
     * 获取数据源对象
     * @return
     * @throws Exception
     */
    public static  DataSource getDruidDataSource() throws Exception {
        if(dataSource  == null){
            //1:读配置文件
            InputStream inputStream = JdbcTemplateUtil.class.getResourceAsStream("/druid.properties");
            Properties properties = new Properties();//用于读.properties的文件
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);//使用properties数据创建连接池
        }
        return dataSource;
    }

}
