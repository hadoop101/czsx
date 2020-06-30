package org.example.p01web;

import org.example.p04bean.PageBean;
import org.example.p04bean.Route;

import java.util.List;
import java.util.Scanner;

public class SearchScreen extends BaseScreen {
    public void show() {
        clear();
        System.out.println("============搜索页面===============");
    }

    public String getKeyWord() {
        System.out.println("请输入搜索词:");
        Scanner scanner = new Scanner(System.in);

        String keyword = scanner.nextLine().trim();

        return keyword;
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
        //显示记录
        showRoutes(pageBean.getList());
        System.out.println("搜索结果有"+pageBean.getTotalCount()+"条记录，分为"+pageBean.getTotalPage()+"页，当前是第"+pageBean.getCurrentPage()+"页");
    }

    public int getCurrentPage() {
        System.out.println("请输入不超出范围的当前的页面数，否则退出搜索：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        return i;

    }
}
