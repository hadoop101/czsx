package org.example.p01web;

import org.example.p04bean.User;

import java.util.Scanner;

public class MyScreen {
    public static void clear() {
        //
        try {
            //windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            //linux
            //new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {

        }
    }

    public void showLogin() {
        clear();
        System.out.println("============登录界面=============");
    }

    public User getData() {
        //1:通过键盘输入的
        //2:通过Scanner对象
        Scanner scanner = new Scanner(System.in);
        //3:nextLine()
        System.out.println("用户名:");
        String username=scanner.nextLine().trim();//去掉字符串的前后空格
        System.out.println("密码:");
        String password=scanner.nextLine().trim();
        //4:保存到对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    public void showResult(int num) {
        if(num == 0){
            System.out.println("登录失败");
        }else{
            System.out.println("登录成功");
        }
    }
}
