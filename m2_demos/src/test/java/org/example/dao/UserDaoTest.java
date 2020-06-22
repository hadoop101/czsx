package org.example.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao;
    @Before
    public void init(){
        //创建对象   类名 对象名 = new 类名(参数)
         userDao = new UserDao();
    }
    @After
    public void destory(){
        userDao = null;
    }
    @Test
    public void testSave() {


        //调用方法
        userDao.save();

    }

    @Test
    public void testUpdate() {

        //调用方法
        userDao.update();
    }

    @Test
    public void testDelete() {


        //调用方法
        userDao.delete();
    }

    @Test
    public void testFind() {


        //调用方法
        userDao.find();
    }
}