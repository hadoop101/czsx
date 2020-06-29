package org.example.service;

import org.example.p02service.UserService;
import org.example.p04bean.User;
import org.junit.Test;

public class StringBuilderTest {

    @Test
    public void test01Login() throws Exception {
        long start = System.currentTimeMillis();
        String result =  "";
        for(int i = 0 ;i<10000;i++){
            result += ( "i = "+i+"\n" );
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(result);
    }
    @Test
    public void test02Login() throws Exception {
        long start = System.currentTimeMillis();

        StringBuilder result =  new StringBuilder();
        for(int i = 0 ;i<10000;i++){
            result.append("i = ").append(i).append("\n");
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(result);
    }



}
