package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class ScannerTest {
    //每一个test方法执行之前，先执行@Before
    //之后再执行destory
    Scanner scanner = null;
    //@Before
    @Before
    public void init(){
        System.out.println("----init");
        //1:创建Scanner 读取键盘录入的数据的一个类
        // 类名 对象名 = new 类名(参数)
         scanner =  new Scanner(System.in);
    }
    //@After
    @After
    public void destory(){
        System.out.println("----destory");
        scanner=null;
    }
     //单元测试，要求给每个测试方法上面加@Test
    @Test
    public void testNextInt() throws InterruptedException {
        System.out.println("----test");

        // 对象名.方法名(参数)
        //nextInt() 读一个整数并把这个整数返回
        System.out.println("请输入一个整数");

        int n = scanner.nextInt();
        System.out.println(n);


    }
    @Test
    public void testNext() throws InterruptedException {

        // 对象名.方法名(参数)
        //next() 读一个字符串并把这个字符串返回 （字符串不能有空格）

        System.out.println("请输入一个字符串:");
        String n = scanner.nextLine();
        System.out.println(n);


    }
}
