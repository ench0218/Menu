package com.ench_wu.youkumenu;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * author:ench_wu
 * Created on 2015/9/22.
 */
public class Anim {
    public static int animationCount = 0;

    /**
     * 关闭菜单的动画
     *
     * @param rl
     * @param startOffset
     */
    public static void closeAnim(RelativeLayout rl, long startOffset) {
        for (int i = 0;i<rl.getChildCount();i++){
            rl.getChildAt(i).setEnabled(false);
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0, -180,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 1);
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(startOffset);
        //动画监听
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                animationCount++;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animationCount--;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        rl.startAnimation(rotateAnimation);
    }

    /**
     * 打开菜单的动画
     *
     * @param rl
     * @param startOffset
     */
    public static void openAnim(RelativeLayout rl, long startOffset) {
        for (int i = 0;i<rl.getChildCount();i++){
            rl.getChildAt(i).setEnabled(true);
        }
        RotateAnimation rotateAnimation = new RotateAnimation(-180, 0,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 1);
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(startOffset);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                animationCount++;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animationCount--;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        rl.startAnimation(rotateAnimation);
    }
}
