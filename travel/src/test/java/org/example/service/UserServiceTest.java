package org.example.service;

import org.example.p02service.UserService;
import org.example.p04bean.User;
import org.junit.Test;
import sun.util.resources.cldr.ebu.CurrencyNames_ebu;

public class UserServiceTest {

    @Test
    public void test01Login() throws Exception {
            //先调用，然后再去实现，细节。好处：逻辑优先

            //1:创建一个业务类对象
            UserService userService = new UserService();

            //2:调用登录方法
            User user = new User();
            user.setUsername("jack");//模拟输入数据
            user.setPassword("1234");

            int result = userService.login(user);

            //3:判断结果
            if(result == 0){
                System.out.println("登录失败");
            }else{
                System.out.println("登录成功");
            }
    }




    @Test
    public void test02Register() throws Exception {

        //1:模拟一个用户
        User  user = new User();
        user.setUsername("hadoop1008");
        user.setPassword("1234");
        user.setEmail("hadoop101@126.com");
        user.setName("rose ttnk");
        user.setSex("M");
        user.setTelephone("1238");
        user.setBirthday("1990-01-20");

        //2:调业务方法 register
        UserService userService = new UserService();
        int code =  userService.register(user);

        //3:根据返回的数据生成提示
        if(1 == code){
            System.out.println("成功");
        }else if(-1 == code){
            System.out.println("失败：用户名已存在");
        }

    }
}
