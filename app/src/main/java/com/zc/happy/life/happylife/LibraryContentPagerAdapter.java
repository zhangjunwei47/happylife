package com.zc.happy.life.happylife;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import java.util.List;

/**
 * 节目库内容区适配器
 * Created by mengxn on 16-12-15.
 */

public class LibraryContentPagerAdapter extends FragmentStatePagerAdapter {

    private List<String> categoryIds;

    public LibraryContentPagerAdapter(FragmentManager fm, List<String> categoryIds) {
        super(fm);
        this.categoryIds = categoryIds;
    }

    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
        this.notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public Fragment getItem(int position) {
        return LibraryContentFragment.create(categoryIds.get(position));
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return categoryIds == null ? 0 : categoryIds.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }
}
