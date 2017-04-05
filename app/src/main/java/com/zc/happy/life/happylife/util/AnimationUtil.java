package com.zc.happy.life.happylife.util;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import com.zc.happy.life.happylife.R;


/******************************************
 * 类描述： 动画工具类 类名称：AnimationUtil
 *
 * @version: 1.0
 * @author: shaoningYang
 * @time: 2015-4-27 14:56
 ******************************************/
public class AnimationUtil {

    /**
     * 创建一个平顺的不停旋转动画对象
     *
     * @param context
     * @return
     */
    public static Animation createSmoothForeverAnimation(Context context) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotate_round);
        animation.setInterpolator(new LinearInterpolator());
        return animation;
    }

    /**
     * 创建一个平顺的不停旋转动画对象
     * 　逆时针旋转
     *
     * @param context
     * @return
     */
    public static Animation createSmoothForeverAnimationAntiClock(Context context) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotate_round_anti_clock);
        animation.setInterpolator(new LinearInterpolator());
        return animation;
    }
}
