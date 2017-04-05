package com.zc.happy.life.happylife.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;

import com.zc.happy.life.happylife.R;
import com.zc.happy.life.happylife.util.AnimationUtil;


/**
 * Created by 刘云龙 on 2016/7/20.
 */
public abstract class KaolaBaseFragmentActivity extends FragmentActivity implements IFragmentActivity {
    private FragmentMgr fragmentMgr = new FragmentMgr(this);
    private View loadingView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public FragmentMgr getFragmentMgr() {
        return fragmentMgr;
    }

    @Override
    public void hideLoading() {
        KaolaBaseFragment kaolaBaseFragment = fragmentMgr.getCurrFragment();
        if (kaolaBaseFragment != null) {
            kaolaBaseFragment.hideLoading();
        } else {
            if (loadingView != null) {
                loadingView.findViewById(R.id.img_login_loading).clearAnimation();
                loadingView.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void showLoading() {
        KaolaBaseFragment kaolaBaseFragment = fragmentMgr.getCurrFragment();
        if (kaolaBaseFragment != null) {
            kaolaBaseFragment.showLoading();
        } else {
            if (loadingView != null) {
                Animation animation = AnimationUtil.createSmoothForeverAnimation(this);
                loadingView.findViewById(R.id.img_login_loading).startAnimation(animation);
                loadingView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void setloadingUnderTouchable(boolean touchAble) {

    }
}
