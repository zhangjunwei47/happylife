package com.zc.happy.life.happylife.base;

import android.app.Activity;

/**
 * Fragment抽象类的委托
 * Created by xkj on 15-5-13.
 */
public class FragmentDelegate implements IFragment{
    private IFragment fragment;
    private IFragmentActivity mActivity;
    public FragmentDelegate(IFragment fragment){
        this.fragment = fragment;
    }

    @Override
    public FragmentMgr getFragmentMgr() {
        return mActivity.getFragmentMgr();
    }

    @Override
    public IFragmentActivity getBaseActivity() {
        return mActivity;
    }

    public void attach(Activity activity){
        if(activity instanceof IFragmentActivity){
            this.mActivity = (IFragmentActivity) activity;
        }else{
            throw new IllegalArgumentException("activity must implements IFragmentActivity!");
        }
    }
}
