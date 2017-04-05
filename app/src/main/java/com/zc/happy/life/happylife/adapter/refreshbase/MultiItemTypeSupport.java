package com.zc.happy.life.happylife.adapter.refreshbase;

/**
 * 多类型adapter支持类
 * @param <T>
 */
public interface MultiItemTypeSupport<T> {
    int getLayoutId(int position, T t);

    int getViewTypeCount();

    int getItemViewType(int postion, T t);
}