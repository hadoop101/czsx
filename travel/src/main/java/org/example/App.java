package org.example;

import org.example.p01web.MyScreen;
import org.example.p01web.UserRegisterScreen;
import org.example.p02service.UserService;
import org.example.p04bean.User;

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
            MyScreen myScreen = new MyScreen();
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

    public static void main(String[] args) throws Exception {
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
}
