package org.example.p03dao;

import org.example.p04bean.Category;
import org.example.util.JdbcTemplateUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//读写数据库
public class CategoryDao {
    //将每一行转成一个对象
    private RowMapper<Category> mapper = new RowMapper<Category>() {
        @Override
        public Category mapRow(ResultSet resultSet, int i) throws SQLException {
            //创建一个对象
            Category category = new Category();
            //给对象赋值上数据库的记录
            category.setCid(resultSet.getLong("cid"));
            category.setCname(resultSet.getString("cname"));
            return category;
        }
    };
    //查询所有的类别
    public List<Category> findAll() throws Exception {
        //写sql
        String sql = "SELECT * FROM tab_category ORDER BY cid";
        //执行sql
        List<Category> list = JdbcTemplateUtil.getJdbcTemplate().query(sql,mapper,new Object[]{});//参1 sql,参2 转换器 参3 参数值
        return list;
    }
}
