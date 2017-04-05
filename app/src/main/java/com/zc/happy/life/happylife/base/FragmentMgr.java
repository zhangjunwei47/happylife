package com.zc.happy.life.happylife.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import com.zc.happy.life.happylife.R;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by 刘云龙 on 2016/7/20.
 */
public class FragmentMgr {
    private final FragmentManager mManager;
    private KaolaBaseFragmentActivity mKaolaBaseFragmentActivity;
    // 当前界面
    private List<KaolaBaseFragment> currFragments = new CopyOnWriteArrayList<>();
    private int containerId;
    private int secondContainerId;
    private String mCurrTabFragmentTag;

    private Handler mHandler;

    public FragmentMgr(KaolaBaseFragmentActivity activity) {
        mManager = activity.getSupportFragmentManager();
        mKaolaBaseFragmentActivity = activity;
        mHandler = new Handler();
    }

    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }

    public void setSecondContainerId(int secondContainerId) {
        this.secondContainerId = secondContainerId;
    }

    public boolean isTabFragment(int containerId) {
        return containerId == this.containerId;
    }

    //    public boolean isSecondFragment(int containerId) {
//        return secondContainerId == secondContainerId;
//    }

    public void showTabFragment(Class<? extends KaolaBaseFragment> fragmentClass) {
        List<KaolaBaseFragment> fragments = getFragmentsByClass(fragmentClass);
        //当前fragment就是要show的fragment
        if (fragments.size() > 0 && fragments.get(0) == getCurrFragment()) {
            return;
        }

        FragmentTransaction transaction = mManager.beginTransaction();
        if (mCurrTabFragmentTag != null) {
            KaolaBaseFragment lastFragment = (KaolaBaseFragment) mManager.findFragmentByTag(mCurrTabFragmentTag);
            if (lastFragment != null) {
                transaction.hide(lastFragment);
            }
        }
        KaolaBaseFragment fragment;
        if (fragments.isEmpty()) {
            fragment = createFragmentByClass(fragmentClass, this.containerId);
            if (fragment != null) {
                transaction.add(this.containerId, fragment, getFragmentTag(fragment));
                int removeIndex = 0;
                while (currFragments.size() > removeIndex) {
                    KaolaBaseFragment f = currFragments.get(removeIndex);
                    if (!isTabFragment(f.getContainerId())) {
                        removeFragment(f);
                    } else {
                        removeIndex++;
                    }
                }
                currFragments.clear();
                currFragments.add(fragment);
            }
        } else {
            //弹出所有二级页
            if (!currFragments.isEmpty()) {
                int removeIndex = 0;
                while (currFragments.size() > removeIndex) {
                    KaolaBaseFragment f = currFragments.get(removeIndex);
                    if (!isTabFragment(f.getContainerId())) {
                        removeFragment(f);
                    } else {
                        removeIndex++;
                    }
                }
            }
            fragment = fragments.get(0);
            currFragments.clear();
            currFragments.add(fragment);
            transaction.show(fragment);
        }
        mCurrTabFragmentTag = getFragmentTag(fragment);
        try {
            transaction.commit();
        } catch (IllegalStateException ill) {
            ill.printStackTrace();
        }
    }

//    public void removeAllFragment() {
//        if (mManager == null) {
//            return;
//        }
//        List<Fragment> fragments = mManager.getFragments();
//        if (fragments == null || fragments.size() == 0) {
//            return;
//        }
//        FragmentTransaction transaction = mManager.beginTransaction();
//        for (int i = 0, size = fragments.size(); i < size; i++) {
//            try {
//                Fragment fragment = fragments.get(i);
//                mManager.popBackStackImmediate();
//                transaction.remove(fragment);
//                transaction.commit();
//            } catch (Throwable t) {
//                t.printStackTrace();
//            }
//        }
//    }

    public void removeFragment(final KaolaBaseFragment fragment) {
        if (fragment != null) {
            try {
                mManager.popBackStackImmediate();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        FragmentTransaction transaction = mManager.beginTransaction();
                        transaction.remove(fragment);
                        transaction.commit();
                    }
                });
//                KL.d(FragmentMgr.class, "removeFragment----------------->2");
                //pop fragment until the remove one,sync manager's fragments
                if (fragment != null) {
                    for (int i = 0; i < currFragments.size(); i++) {
                        Fragment fragment1 = currFragments.get(i);
                        if (fragment1 == null) {
                            continue;
                        }
                        if (TextUtils.equals(fragment1.getClass().getName(), fragment.getClass().getName())) {
                            currFragments.remove(fragment);
                            break;
                        }
                    }
                }
                //通知当前fragment已经显示
                KaolaBaseFragment curr = getCurrFragment();
                notifyFragmentHiddenChanged(curr, false);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    public KaolaBaseFragment addFragment(Class<? extends KaolaBaseFragment> fragmentClass) {
        return addFragment(fragmentClass, null, PageAnimations.DEFAULT_ANIM, secondContainerId);
    }

    public KaolaBaseFragment addFragmentWithAnim(Class<? extends KaolaBaseFragment> fragmentClass, int[] anims) {
        return addFragment(fragmentClass, null, anims, secondContainerId);
    }

    public KaolaBaseFragment addFragment(Class<? extends KaolaBaseFragment> fragmentClass, Bundle args) {
        return addFragment(fragmentClass, args, PageAnimations.DEFAULT_ANIM, secondContainerId);
    }

    public KaolaBaseFragment addFragment(Class<? extends KaolaBaseFragment> fragmentClass, Bundle args, int[] anims) {
        return addFragment(fragmentClass, args, true, anims, secondContainerId);
    }

    public KaolaBaseFragment addFragment(Class<? extends KaolaBaseFragment> fragmentClass, Bundle args, int[] anims, int containerId) {
        return addFragment(fragmentClass, args, true, anims, containerId);
    }

    public KaolaBaseFragment addFragment(Class<? extends KaolaBaseFragment> fragmentClass, Bundle args, boolean addToBackStack, int[] anims, int containerId) {
        FragmentTransaction transaction = mManager.beginTransaction();
        if (anims != null && anims.length >= 4) {
            transaction.setCustomAnimations(anims[0], anims[1], anims[2], anims[3]);
        }
        KaolaBaseFragment newFragment = createFragmentByClass(fragmentClass, containerId);
        String tag = null;
        if (newFragment != null) {
            tag = getFragmentTag(newFragment);
            if (args != null) {
                newFragment.setArguments(args);
            }
            transaction.add(containerId, newFragment, tag);
            //若当前界面与需要添加的界面是相同的类,则去掉上一个.
            KaolaBaseFragment currF = getCurrFragment();
            if (currF != null && currF.getClass().equals(fragmentClass)) {
                removeFragmentWithAnim(currF, PageAnimations.NO_ANIM);
            }
            if (containerId == this.secondContainerId) {
                //通知当前fragment被隐藏
                KaolaBaseFragment curr = getCurrFragment();
                notifyFragmentHiddenChanged(curr, true);
                currFragments.add(0, newFragment);
            }
        }
        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }
        try { // 解决umeng http://mobile.umeng.com/apps/28bd206837b042655f921b15/error_types/show?error_type_id=51b129f556240b738602db82_6454010799598988148_4.8.1 问题
            transaction.commitAllowingStateLoss();
        } catch (IllegalStateException ill) {
            ill.printStackTrace();
        }
        return newFragment;
    }

    public KaolaBaseFragment getCurrFragment() {
        if (currFragments.size() > 0) {
            return currFragments.get(0);
        } else {
            return null;
        }
    }

    private KaolaBaseFragment createFragmentByClass(Class<? extends KaolaBaseFragment> fragmentClass, int containerId) {
        KaolaBaseFragment fragment = null;
        Constructor<?> constructor;
        try {
            constructor = fragmentClass.getConstructor();
            fragment = (KaolaBaseFragment) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            fragment.setContainerId(containerId);
        }
        return fragment;
    }

    private String getFragmentTag(KaolaBaseFragment kaolaBaseFragment) {
        return kaolaBaseFragment.getUniqueTag();
    }

    public boolean removeFragmentWithAnim(final KaolaBaseFragment oldFragment, final int[] anims) {
        boolean isRemoved = false;
        if (oldFragment != null) {
            try {
                mManager.popBackStackImmediate();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        FragmentTransaction transaction = mManager.beginTransaction();
                        if (anims != null && anims.length >= 4) {
                            transaction.setCustomAnimations(anims[0], anims[1], anims[2], anims[3]);
                        }
                        transaction.remove(oldFragment);
                        transaction.commitAllowingStateLoss();
                    }
                });
                for (int i = 0; i < currFragments.size(); i++) {
                    KaolaBaseFragment f = currFragments.get(0);
                    currFragments.remove(f);
                    //pop fragment until the remove one
                    if (f == oldFragment) {
                        break;
                    }
                }
                notifyFragmentHiddenChanged(getCurrFragment(), false);
            } catch (IllegalStateException ill) {
                ill.printStackTrace();
            }
            isRemoved = true;
        }
        return isRemoved;
    }


    public List<KaolaBaseFragment> getFragmentsByClass(Class<? extends KaolaBaseFragment> fragmentClass) {
        String tagPrefix = fragmentClass.getName() + KaolaBaseFragment.TAG_CONNECTOR;
        List<Fragment> fragments = mManager.getFragments();
        List<KaolaBaseFragment> kaolaBaseFragments = new ArrayList<>();
        if (fragments != null) {
            for (int i = 0, size = fragments.size(); i < size; i++) {
                Fragment f = fragments.get(i);
                if (f != null && f.getTag() != null && f.getTag().startsWith(tagPrefix)) {
                    kaolaBaseFragments.add((KaolaBaseFragment) f);
                }
            }
        }
        return kaolaBaseFragments;
    }

    private void notifyFragmentHiddenChanged(KaolaBaseFragment kaolaBaseFragment, boolean isHidden) {
        if (kaolaBaseFragment != null && kaolaBaseFragment.isAdded()) {
            kaolaBaseFragment.onHiddenChanged(isHidden);
        }
    }

    /**
     * 转场动画
     */
    public static class PageAnimations {
        private static int ri = R.anim.push_right_in,
                ro = R.anim.push_right_out, li = R.anim.push_left_in,
                lo = R.anim.push_left_out, ti = R.anim.push_top_in,
                to = R.anim.push_top_out, ai = R.anim.alpha_in,
                ao = R.anim.alpha_out, bi = R.anim.push_bottom_in,
                bo = R.anim.push_bottom_out;
        // 右进右出
        public static int[] RIRO_ANIM = new int[]{ri, ro, ri, ro};
        // 左进右出
        public static int[] LIRO_ANIM = new int[]{li, ro, li, ro};
        // 右出
        public static int[] RO_ANIM = new int[]{0, ro, 0, ro};
        // 左出
        public static int[] LO_ANIM = new int[]{0, lo, 0, lo};
        // 上进上出
        public static int[] TITO_ANIM = new int[]{ti, to, ti, to};
        // 下进下出
        public static int[] BIBO_ANIM = new int[]{bi, bo, bi, bo};
        // 上出
        public static int[] TO_ANIM = new int[]{0, to, 0, to};
        //
        public static int[] RRLL_ANIM = new int[]{ri, ro, li, lo};
        //
        public static int[] LLRR_ANIM = new int[]{li, lo, ri, ro};
        //alpha in out
        public static int[] AA_ANIM = new int[]{ai, ao, ai, ao};
        //no anim
        public static int[] NO_ANIM = new int[]{0, 0, 0, 0};
        // 默认 右进右出
        public static int[] DEFAULT_ANIM = RIRO_ANIM;
    }



    /**
     * 获取Fragment所有者Activity
     *
     * @return
     */
    public KaolaBaseFragmentActivity getKaolaBaseFragmentActivity() {
        return mKaolaBaseFragmentActivity;
    }

    /**
     * 根据tag获取当前FragmentManager中所管理Fragment实例
     *
     * @param tag
     * @return
     */
    public KaolaBaseFragment getFragmentByTag(String tag) {
        if (mManager == null) {
            return null;
        }
        Fragment fragment = mManager.findFragmentByTag(tag);
        if (fragment instanceof KaolaBaseFragment) {
            return (KaolaBaseFragment) fragment;
        }
        return null;
    }
}
