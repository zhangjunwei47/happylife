package com.zc.happy.life.happylife.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/*************************************
 * 类名称：Class Name
 * 类描述：Do What
 *
 * @version: 2.3.2
 * @author: 刘云龙
 * @time: 2016/12/14
 **********************************/
public class HomeAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragments;

    public HomeAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        if (mFragments != null && !mFragments.isEmpty()) {
            return mFragments.get(position);
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }
}
