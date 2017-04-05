package com.zc.happy.life.happylife.base;

/**
 * Created by xkj on 15-5-13.
 */
public interface IFragmentActivity {
    FragmentMgr getFragmentMgr();

    void hideLoading();

    void showLoading();

    void setloadingUnderTouchable(boolean touchAble);
}
