package org.example.service;

import org.example.p02service.CategoryService;
import org.example.p02service.RouteService;
import org.example.p04bean.Category;
import org.example.p04bean.PageBean;
import org.example.p04bean.Route;
import org.junit.Test;

import java.util.List;

public class RouteServiceTest {

    @Test
    public void test01FindByCid() throws Exception {
            //1:创建线路的业务对象
            RouteService routeService = new RouteService();
            //2:传一个分类cid
            Integer cid = 5;//模拟
            List<Route> list = routeService.findRoutesByCid(cid);
            //3:查找获得结果
            System.out.println(list);
    }

    @Test
    public void test02FindByCid() throws Exception {
        //1:创建线路的业务对象
        RouteService routeService = new RouteService();
        //2:传一个分类cid
        Integer cid = 5;//模拟  100   20   5
        PageBean<Route> pageBean = routeService.queryByPage(cid,20,3);
        //3:查找获得结果
        System.out.println(pageBean);
    }


}
