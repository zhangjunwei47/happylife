package com.zc.happy.life.happylife.base.mvp;

import android.os.Bundle;

import com.zc.happy.life.happylife.base.KaolaBaseFragment;


/**
 * MVP模式 Fragment基类
 * 泛型中第一个类型是V的接口，第二个是V接口对应的P
 * Created by xkj on 15-11-9.
 */
public abstract class MVPBaseFragment<V extends BaseViewInterface, T extends BasePresenter<V>>
        extends KaolaBaseFragment {
    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (mPresenter != null) { // 解决19089问题
            mPresenter.onHiden(hidden);
        }
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    protected abstract T createPresenter();
}
