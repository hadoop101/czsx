package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
做一个时间显示器，每隔一秒更新当前时间
 */
public class Demo01 {
    public static void main(String[] args) {
            //1:获取当前时间
//             String time = getNowTime();
//             System.out.println(time);
            //2:每秒更新  Time定时器
             Timer  timer = new Timer();
            //3:设置定时的时间间隔
            timer.schedule(new TimerTask() {
                @Override
                public void run() {//run方法里面写定时的任务代码
                    String time = getNowTime();
                    System.out.println(time);
                }
            },1000, 1000);//参1 操作任务  参2等待时间  参3 时间间隔 毫秒

    }

    private static String getNowTime() {
        //创建时间对象 ：Mon Jun 22 09:39:20 CST 2020
        Date date = new Date();
        //时间格式对象  yyyy年MM月dd日 hh时mm分ss秒
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        String t = format.format(date);
        return t;
    }
}
