package org.example.p01web;

import java.util.Scanner;

public class WelcomeScreen extends BaseScreen{
    public void loading() throws InterruptedException {
        //1%  100%
        clear();
        for(int i = 1; i<=100;i++){

            Thread.sleep(5  );//等待

            clear();

            System.out.println("系统加载中:"+i+ "%");

        }
    }

    public void show() {
        clear();
        System.out.println("=====================欢迎页面=====================");
        System.out.println("1：注册");
        System.out.println("2：登录");
        System.out.println("其他数字：退出");


    }
    public int getNum(){
        System.out.println("请输入操作前的数字:");

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        return n;
    }
}
