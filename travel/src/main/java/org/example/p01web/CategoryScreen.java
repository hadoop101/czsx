package org.example.p01web;

import org.example.p04bean.Category;

import java.util.List;

//自动拥有clear方法
public class CategoryScreen extends BaseScreen{
    public void show() {
        clear();
        System.out.println("===========分类页面==========");
    }

    public void show(List<Category> list) {
        //创建StringBuilder
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            //拼接一条记录
            Category category = list.get(i);
            stringBuilder.append(category.getCid()).append(" ").append(category.getCname()).append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}
