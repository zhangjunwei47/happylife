package com.zc.happy.life.happylife.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.zc.happy.life.happylife.MyApplication;
import com.zc.happy.life.happylife.R;


public class KaolaBaseFragment extends Fragment implements IFragment<KaolaBaseFragmentActivity> {
    /**
     * 延迟（500毫秒）加载数据
     */
    public static final int DELAY_INIT_DATA_TIME_COUNT = 500;
    public final static String TAG_CONNECTOR = "-";
    private String UNIQUE_TAG;
    private int mContainerId;
    private FragmentDelegate fragmentDelegate = new FragmentDelegate(this);
    private View loadingView;

    /**
     * 当前是否显示界面 true为是，false为否
     */
    protected boolean isPageShow;

    public boolean isPageShow() {
        return isPageShow;
    }

    public void setPageShow(boolean pageShow) {
        isPageShow = pageShow;
    }

    public void reLoadData() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        fragmentDelegate.attach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadingView = getActivity().getLayoutInflater().inflate(R.layout.dialog_loading_layout, null);
        loadingView.setVisibility(View.GONE);
        try {
            ((ViewGroup) view).addView(loadingView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        } catch (UnsupportedOperationException uoe) {
            uoe.printStackTrace();
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }


    /**
     * 初始化数据
     */
    protected void initData() {
    }

    /**
     * 初始化View
     */
    protected void initView(View view) {
    }

    public String getUniqueTag() {
        if (UNIQUE_TAG == null) {
            StringBuilder stringBuilder = new StringBuilder();
            UNIQUE_TAG = stringBuilder.append(getClass().getName()).append(TAG_CONNECTOR).append(hashCode()).toString();
        }
        return UNIQUE_TAG;
    }

    public int getContainerId() {
        return mContainerId;
    }

    public void setContainerId(int containerId) {
        this.mContainerId = containerId;
    }

    @Override
    public FragmentMgr getFragmentMgr() {
        return fragmentDelegate.getFragmentMgr();
    }

    @Override
    public KaolaBaseFragmentActivity getBaseActivity() {
        return (KaolaBaseFragmentActivity) fragmentDelegate.getBaseActivity();
    }

    public boolean onBackPressed() {
//        if (isLoadingShow()) {
//            hideLoading();
//            return true;
//        }
        return false;
    }

    public void hideLoading() {
        if (loadingView != null && loadingView.getVisibility() != View.GONE) {
            loadingView.findViewById(R.id.img_login_loading).clearAnimation();
            loadingView.setVisibility(View.GONE);
        }
    }

    public void showLoading() {
        if (loadingView != null && loadingView.getVisibility() != View.VISIBLE && getActivity() != null) {
            Animation animation = AnimationUtil.createSmoothForeverAnimation(getActivity());
            loadingView.findViewById(R.id.img_login_loading).startAnimation(animation);
            loadingView.setVisibility(View.VISIBLE);
        }
    }

//    protected boolean isLoadingShow() {
//        boolean flag = loadingView != null && loadingView.getVisibility() == View.VISIBLE;
//        return flag;
//    }

    /**
     * 设置在loading时，是否可以点击loading下的其他按钮
     *
     * @param touchAble
     */
    public void setLoadingUnderTouchable(final boolean touchAble) {
        if (loadingView != null) {
            loadingView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return !touchAble;
                }
            });
        }
    }

    /**
     * 获取一个安全的Context如果需要使用KaolaBaseFragmentActivity需要自行处理所返回实例是否为自己所需实例
     *
     * @return
     */
    public Context getActivitySafely() {
        Context context = getActivity();
        if (context == null) {
            return MyApplication.mContext;
        }
        return context;
    }

    /**
     * 通过一种更合适的方式获取Res对象
     *
     * @return
     */
    public Resources getResourcesSafely() {
        return getActivitySafely().getResources();
    }

    /**
     * 判断当前Fragment是否可见
     *
     * @return true为是，false为否
     */
    public boolean isFragmentVisible() { // 解决22799问题
        FragmentMgr fragmentMgr = getFragmentMgr();
        if (fragmentMgr == null) {
            return false;
        }
        Fragment fragment = fragmentMgr.getCurrFragment();
        if (fragment == null) {
            return false;
        }
        if (TextUtils.equals(fragment.getClass().getCanonicalName(), this.getClass().getCanonicalName())) {
            return true;
        }
        return false;
    }
}
