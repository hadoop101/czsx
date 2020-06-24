package org.example.p02service;

import org.example.p03dao.UserDao;
import org.example.p04bean.User;

//当前是service业务层，业务层调用数据访问层，即dao
public class UserService {
    public int login(User user) throws Exception {
        //创建dao对象
        UserDao userDao = new UserDao();
        //调用根据账号与密码查询用户的方法
        int num  = userDao.findByUserNamePassword(user.getUsername(),user.getPassword());
        return num;
    }
}
