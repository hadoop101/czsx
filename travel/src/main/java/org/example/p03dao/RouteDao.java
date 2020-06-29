package org.example.p03dao;

import org.example.p04bean.Route;
import org.example.util.JdbcTemplateUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//数据访问层
public class RouteDao {
    RowMapper<Route> mapper = new RowMapper<Route>() {
        @Override
        public Route mapRow(ResultSet resultSet, int i) throws SQLException {
            //创建对象Route
            Route route = new Route();

            //给它成员变量赋值
            route.setRid(resultSet.getLong("rid"));
            route.setRname(resultSet.getString("rname"));
            route.setIntroduce(resultSet.getString("routeIntroduce"));
            route.setPrice(resultSet.getDouble("price"));
            route.setRdate(resultSet.getString("rdate"));

            return route;//返回赋完值的对象
        }
    };
    public List<Route> findByCid(Integer cid) throws Exception {
        //写sql
        String sql = "SELECT * FROM tab_route WHERE cid = ?";
        //执行sql
        //queryForList  查一个列表  参1 sql  参2转换器 参3 参数值

        List<Route> list = JdbcTemplateUtil.getJdbcTemplate().query(sql,mapper,cid);
        return list;
    }
}
