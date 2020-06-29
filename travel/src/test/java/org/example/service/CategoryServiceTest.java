package org.example.service;

import org.example.p02service.CategoryService;
import org.example.p02service.UserService;
import org.example.p04bean.Category;
import org.example.p04bean.User;
import org.junit.Test;

import java.util.List;

public class CategoryServiceTest {

    @Test
    public void test01FindAll() throws Exception {
            //1:创建业务类
            CategoryService categoryService = new CategoryService();
            //2:查询所有的分类数据
            List<Category> list = categoryService.findAll();
            //3:打印
            System.out.println(list);
    }




}
