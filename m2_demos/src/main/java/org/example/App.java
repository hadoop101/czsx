package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //1:创建Scanner 读取键盘录入的数据的一个类
        // 类名 对象名 = new 类名(参数)
        Scanner scanner =  new Scanner(System.in);
        // 对象名.方法名(参数)
        //nextInt() 读一个整数并把这个整数返回
        System.out.println("请输入一个整数");
        try {
            int n = scanner.nextInt();
            System.out.println(n);
        } catch (Exception exception) {

        }
        //next() 读一个字符串并把这个字符串返回 （字符串不能有空格）
        /*
        System.out.println("请输入一个字符串:");
        String n = scanner.nextLine();
        System.out.println(n);
         */
        //nextLine() 读一个字符串并把这个字符串返回

    }
}
