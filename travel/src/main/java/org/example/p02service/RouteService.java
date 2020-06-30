package org.example.p02service;

import org.example.p03dao.RouteDao;
import org.example.p04bean.PageBean;
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

    //参1 分类cid
    //参2 一页的记录数
    //参3 当前页
    public PageBean<Route> queryByPage(Integer cid, int pageSize, int currentPage) throws Exception {
        //创建分页数
        PageBean<Route> pageBean = new PageBean<Route>();

        //设置每页记录数  20
        pageBean.setPageSize(pageSize);

        //当前是第几页  3
        pageBean.setCurrentPage(currentPage);

        //其他数据，都要通过dao查询
        RouteDao routeDao = new RouteDao();
        //查询总记录数 100
        int count = routeDao.findCount(cid);
        pageBean.setTotalCount(count);

        //页数  20 在java中，整数相除丢失小数部分 5
        int page = 0;
        if(count % pageSize == 0){
            page= count / pageSize;
        }else{
            page= count / pageSize + 1;
        }
        pageBean.setTotalPage(page);

        //当前页的集合
       List<Route> list= routeDao.findPage(cid,pageSize,currentPage);
       pageBean.setList(list);

       return pageBean;
    }
}
