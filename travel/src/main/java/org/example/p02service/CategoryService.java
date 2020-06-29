package org.example.p02service;

import org.example.p03dao.CategoryDao;
import org.example.p04bean.Category;

import java.util.List;

public class CategoryService {
    //查询所有的类别数据
    public List<Category> findAll() throws Exception {
        //创建 Dao
        CategoryDao categoryDao = new CategoryDao();
        //调findAll
        List<Category> list =categoryDao.findAll();
        //返回
        return list;
    }
}
