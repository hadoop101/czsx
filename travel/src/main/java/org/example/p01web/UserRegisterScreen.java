package org.example.p01web;

import org.example.p04bean.User;

import java.util.Scanner;

//用户的注册页面
public class UserRegisterScreen {
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
    public void show() {
        clear();
        System.out.println("==============用户注册=============");
    }

    public void showResult(int code) {
        clear();
        if(1 == code){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败：用户已存在，建议更换用户名");
        }
    }

    public User getData() {
        //创建新用户对象
        User user = new User();

        //创建Scanner
        Scanner scanner = new Scanner(System.in);

        //提示用户输入数据
        System.out.println("请输入用户名:");
        user.setUsername(scanner.nextLine().trim());

        System.out.println("请输入密码:");
        user.setPassword(scanner.nextLine().trim());

        System.out.println("请输入姓名:");
        user.setName(scanner.nextLine().trim());

        System.out.println("请输入出生日期(如1990-01-01):");
        user.setBirthday(scanner.nextLine().trim());

        System.out.println("请输入出生性别（男/女):");
        user.setSex(scanner.nextLine().trim());

        System.out.println("请输入手机号:");
        user.setTelephone(scanner.nextLine().trim());

        System.out.println("请输入邮箱(如:hadoop101@126.com):");
        user.setEmail(scanner.nextLine().trim());
        return  user;
    }
}
