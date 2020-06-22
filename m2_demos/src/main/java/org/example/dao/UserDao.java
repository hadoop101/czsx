package org.example.dao;

public class UserDao {
    public void save(){
        System.out.println("保存");
    }
    public void update(){
        System.out.println("更新");
        int a = 10;
        int b = 1;
        System.out.println(a/b);
    }
    public void delete(){
        System.out.println("删除");
    }
    public void find(){
        System.out.println("查找");
    }
}
