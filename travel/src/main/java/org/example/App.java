package org.example;

import org.example.p01web.CategoryScreen;
import org.example.p01web.UserLoginScreen;
import org.example.p01web.UserRegisterScreen;
import org.example.p02service.CategoryService;
import org.example.p02service.RouteService;
import org.example.p02service.UserService;
import org.example.p04bean.Category;
import org.example.p04bean.PageBean;
import org.example.p04bean.Route;
import org.example.p04bean.User;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main1( String[] args )
    {
        //3次重试的机会
        for(int i = 0;i<3;i++){

             //1:显示登录界面
            UserLoginScreen myScreen = new UserLoginScreen();
            myScreen.showLogin();
            //2:获取界面输入的数据
            User user = myScreen.getData();
            //3:调用登录的业务方法 Ctrl+/ 注册
            UserService userService = new UserService();
            try {
                int num = userService.login(user);
               //4:根据业务方法返回结果来显示成功界面或者失败界面
                myScreen.showResult(num);
                if(num != 0){
                    break;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void main2(String[] args) throws Exception {
        //1:显示注册页面
        UserRegisterScreen registerScreen = new UserRegisterScreen();
        registerScreen.show();
        //2:提示输入用户信息

        //3:拿到信息
        User user = registerScreen.getData();

        //4:调用register注册方法
        UserService userService = new UserService();
        int code = userService.register(user);
        registerScreen.showResult(code);
    }

    public static void main(String[] args) throws Exception {
        categoryLogic();
    }
    public static void categoryLogic()throws Exception{
        //显示当前是分类页面
        CategoryScreen  categoryScreen = new CategoryScreen();
        categoryScreen.show();

        //取数据来显示在页面
        CategoryService categoryService = new CategoryService();
        List<Category> list = categoryService.findAll();

        categoryScreen.show(list);
        //输入一个整数(cid)，显示该分类下的旅游信息
        int cid = categoryScreen.getCid();

        //调用业务方法获取分类下的路线信息
        RouteService routeService = new RouteService();
        //List<Route> routeList = routeService.findRoutesByCid(cid);
        //使用分页的业务逻辑
        int pageSize = 10; //给定一页显示的数量
        int currPage = -1;
        PageBean<Route> pageBean = null;

        //51=> 1 2 3 4 ..
        while(true){
            //
            if(currPage == -1){
                currPage = 1;
                pageBean =  routeService.queryByPage(cid,pageSize,currPage);
                categoryScreen.showPageBean(pageBean);
            }
            //接下来让用户输入页号
            currPage = categoryScreen.getCurrentPage(pageBean);
            //判断 如果是在页号范围内的数据，查询显示分页，否则退回分类页面
            if(currPage >= 1 && currPage <= pageBean.getTotalPage()){
                pageBean =  routeService.queryByPage(cid,pageSize,currPage);
                categoryScreen.showPageBean(pageBean);
            }else{
                categoryLogic();
                break;
            }

        }

        //显示

        //让用户选择显示哪个分页的数据

        //categoryScreen.showRoutes(routeList);
    }
}
