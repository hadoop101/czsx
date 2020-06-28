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

    public int register(User user) throws Exception {
        //因为这个账号是不能相同的，所以把用户数据保存到数据库之前，必须进行判断
        //查询
        UserDao userDao = new UserDao();
        //根据结果来处理 不存在，保存  否则  返回
        int count = userDao.findByUserName(user.getUsername());

        if( count == 0){
            userDao.save(user);
            return 1;
        }else{
            return -1;
        }
    }
}
