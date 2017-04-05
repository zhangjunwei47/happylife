package com.zc.happy.life.happylife;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zc.happy.life.happylife.adapter.refreshbase.ViewHolder;

import java.util.List;

/**
 * 一级分类适配器
 * Created by mengxn on 16-12-15.
 */
public class CategoryAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> dataList;

    public CategoryAdapter(Context context, List<String> dataList) {
        this.mContext = context;
        this.dataList = dataList;
    }

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.dataList == null ? 0 : this.dataList.size();
    }

    @Override
    public Object getItem(int position) {
        if (dataList == null || dataList.size() < position) {
            return null;
        }
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, R.layout.item_library_catetory, 0);
        String text = dataList.get(position);
        holder.setText(R.id.text, text);
        return holder.getConvertView();
    }
}
