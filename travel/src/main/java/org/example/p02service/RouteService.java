package org.example.p02service;

import org.example.p03dao.RouteDao;
import org.example.p04bean.Route;

import java.util.List;
//业务层
public class RouteService {

    //使用用户输入的分类id 查找所有的路线数据
    public List<Route> findRoutesByCid(Integer cid) throws Exception {
        //创建dao对象
        RouteDao routeDao = new RouteDao();
        //调用查询
        List<Route> list =  routeDao.findByCid(cid);
        //返回
        return  list;
    }
}
