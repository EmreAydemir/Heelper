package com.emreaydemir.heelper.Util;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

public class AnimationUtil {


    public static void slideUpAndDown (View animationView, ViewGroup mainView, boolean isUp){
        Transition transition = new Slide(Gravity.BOTTOM);
        transition.setDuration(500);
        transition.addTarget(animationView);

        TransitionManager.beginDelayedTransition(mainView, transition);
        animationView.setVisibility(isUp ? View.VISIBLE : View.GONE);

    }


    public static void tabBarActionButtonRotate(View view, boolean isUp){
        if(isUp) {
            RotateAnimation rotate = new RotateAnimation(0, -45, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(200);
            rotate.setInterpolator(new LinearInterpolator());
            rotate.setFillAfter(true);

            view.startAnimation(rotate);
        }
        else{
            RotateAnimation rotate = new RotateAnimation(-45, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(200);
            rotate.setInterpolator(new LinearInterpolator());
            rotate.setFillAfter(true);

            view.startAnimation(rotate);
        }
    }
}
