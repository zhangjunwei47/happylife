package com.zc.happy.life.happylife.base.mvp;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.zc.happy.life.happylife.MyApplication;
import com.zc.happy.life.happylife.base.KaolaBaseFragment;

import java.lang.ref.WeakReference;

/**
 * MVP模式Presenter基类
 * Created by xkj on 15-11-9.
 */
public class BasePresenter<T> {

    /**
     * 请求接口成功但是服务端返回空数据
     */
    public static final int DATA_RETURN_NULL = -10000;
    /**
     * 请求接口成功但是服务端返回的数据对象和定义的不一样
     */
    public static final int CLASS_NOT_MATCH = -10001;

    protected WeakReference<T> mViewRef;

    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public void onHiden(boolean hiden) {

    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    protected T getViewInterface() {
        if (isViewAttached()) {
            return mViewRef.get();
        } else {
            return null;
        }
    }

    protected Activity getActivity() {
        if (isViewAttached()) {
            T t = mViewRef.get();
            if (t instanceof Activity) {
                return (Activity) t;
            } else if (t instanceof Fragment) {
                return ((Fragment) t).getActivity();
            }
        }
        return null;
    }

    protected Fragment getFragment() {
        if (isViewAttached()) {
            T t = mViewRef.get();
            if (t instanceof Fragment) {
                return (Fragment) t;
            }
        }
        return null;
    }

    protected Context getContext() {
        if (isViewAttached()) {
            T t = mViewRef.get();
            if (t instanceof Fragment) {
                return ((Fragment) t).getActivity();
            } else if (t instanceof Context) {
                return (Context) t;
            }
        }
        return null;
    }

    /**
     * 获取资源context
     * @return
     */
    protected Context getResourceContext() {
        return MyApplication.mContext;
    }

    public void showLoading() {
        Fragment fragment = getFragment();
        if (fragment instanceof KaolaBaseFragment) {
            ((KaolaBaseFragment) fragment).showLoading();
        }
    }

    public void hideLoading() {
        Fragment fragment = getFragment();
        if (fragment instanceof KaolaBaseFragment) {
            ((KaolaBaseFragment) fragment).hideLoading();
        }
    }
}
