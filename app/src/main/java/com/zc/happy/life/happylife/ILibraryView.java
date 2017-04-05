package com.zc.happy.life.happylife;

import com.zc.happy.life.happylife.base.mvp.BaseViewInterface;

import java.util.List;

/**
 * Created by mengxn on 16-12-15.
 */

public interface ILibraryView extends BaseViewInterface {

    /**
     * 刷新一级分类列表
     * @param categoryList
     */
    void refreshCategoryList(List<String> categoryList);

    /**
     * 刷新Tab（二级分类列表）
     * @param tabList
     */
    void refreshTab(List<String> tabList);

}
