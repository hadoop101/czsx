package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidTest {
    @Test
    public void test01Druid() throws Exception {
        //获取连接
        Connection connection = getConnection();
        //打印
        System.out.println(connection);
    }

    private Connection getConnection() throws Exception {
        //1:读配置文件
        InputStream inputStream = DruidTest.class.getResourceAsStream("/druid.properties");
        Properties properties = new Properties();//用于读.properties的文件
        properties.load(inputStream);
        System.out.println(properties.getProperty("druid.username"));
        //2:设置给Druid 对象
        DruidDataSource source = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);//使用properties数据创建连接池
        //3:取连接
        System.out.println(source);
        return source.getConnection();
    }
}
