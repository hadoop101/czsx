package org.example.p01web;

import org.example.p04bean.Category;
import org.example.p04bean.PageBean;
import org.example.p04bean.Route;

import java.util.List;
import java.util.Scanner;

//自动拥有clear方法
public class CategoryScreen extends BaseScreen{
    public void show() {
        clear();
        System.out.println("===========分类页面==========");
    }

    public void show(List<Category> list) {
        //创建StringBuilder
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            //拼接一条记录
            Category category = list.get(i);
            stringBuilder.append(category.getCid()).append(" ").append(category.getCname()).append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

    public int getCid() {
        System.out.println("请输入分类名前的一个整数：");

        Scanner scanner =  new Scanner(System.in);
        //请一个整数
        int i = scanner.nextInt();

        return i;
    }

    //显示一个分类下的路线数据
    public void showRoutes(List<Route> routeList) {
        //使用stringBuilder
        StringBuilder stringBuilder = new StringBuilder();

        //循环
        for (int i = 0; i < routeList.size(); i++) {
            //取出一个对象
            Route route = routeList.get(i);
            //将对象的数据拼接到stringBuilder
            stringBuilder.append(route.getRname()).append("\n");//1

            //stringBuilder.append(route.getRid()).append(" | ");//2
            stringBuilder.append(route.getPrice()).append("￥ | ");
            stringBuilder.append(route.getRdate()).append("\n");//3
            stringBuilder.append(route.getIntroduce()).append("\n");//4

            stringBuilder.append("==========================================\n");//

        }

        System.out.println(stringBuilder.toString());
    }

    public void showPageBean(PageBean<Route> pageBean) {
        clear();
        System.out.println("=================路线页面===============");
        showRoutes(pageBean.getList());//10条记录
    }

    public int getCurrentPage(PageBean<Route> pageBean) {
        System.out.println("【当前是第"+pageBean.getCurrentPage()+"页,共"+pageBean.getTotalPage()+"页】");
        System.out.println("可以输入页号：1到"+pageBean.getTotalPage()+":");

        Scanner scanner = new Scanner(System.in);
        int num  =  scanner.nextInt();
        return  num;
    }
}
