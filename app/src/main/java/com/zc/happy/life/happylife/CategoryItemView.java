package com.zc.happy.life.happylife;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;

/**
 * 一级分类Item封装
 * Created by mengxn on 16-12-15.
 */
public class CategoryItemView extends LinearLayout implements Checkable {

    public CategoryItemView(Context context) {
        this(context, null);
    }

    public CategoryItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
    }

    @Override
    public void setChecked(boolean checked) {
        setSelected(checked);
    }

    @Override
    public boolean isChecked() {
        return isSelected();
    }

    @Override
    public void toggle() {
        setChecked(!isChecked());
    }
}
