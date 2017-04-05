package com.zc.happy.life.happylife;


import com.zc.happy.life.happylife.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * 节目库Presenter
 * Created by mengxn on 16-12-15.
 */

public class LibraryPresenter extends BasePresenter<ILibraryView> {

    /**
     * 获取一级分类
     */
    public void getCategory() {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add("item " + i);
        }
        getViewInterface().refreshCategoryList(dataList);
    }

    /**
     * 获取二级分类
     * @param categoryId 一级分类ID
     */
    public void getCategory(String categoryId) {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            dataList.add(categoryId + i);
        }
        getViewInterface().refreshTab(dataList);
    }

    public void getContent(int categoryId) {

    }
}
