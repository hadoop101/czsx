package org.example.service;

import org.example.p02service.RouteService;
import org.example.p04bean.PageBean;
import org.example.p04bean.Route;
import org.junit.Test;

import java.util.List;

public class SearchServiceTest {

    @Test
    public void test01Search() throws Exception {
            //1:创建线路的业务对象
            RouteService routeService = new RouteService();
            //2:调用搜索方法获取一个分页数据
            PageBean<Route> pageBean = routeService.search("广州",20,1);
            //3:打印
            System.out.println(pageBean);
    }



}
