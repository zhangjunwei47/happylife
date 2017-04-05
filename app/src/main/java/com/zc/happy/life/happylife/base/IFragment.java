package com.zc.happy.life.happylife.base;

/**
 * Created by xkj on 15-5-13.
 */
public interface IFragment<A extends IFragmentActivity> {
    FragmentMgr getFragmentMgr();

    A getBaseActivity();
}
