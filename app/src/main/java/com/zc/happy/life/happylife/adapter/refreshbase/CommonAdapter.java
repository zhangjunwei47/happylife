package com.zc.happy.life.happylife.adapter.refreshbase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 通用adapter，绑定数据和layout
 * @param <T>
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    private int layoutId;

    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
        this.layoutId = layoutId;
    }

    public List<T> getDatas() {
        return mDatas;
    }

    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent,
                layoutId, position);
        convert(holder, getItem(position), convertView == null,position);
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T t, boolean isInitConvertView,int position);

    public void notifyDataSetChanged(List<T> datas) {
        if (mDatas != null) {
            mDatas.clear();
            mDatas.addAll(datas);
            super.notifyDataSetChanged();
        }
    }
}
