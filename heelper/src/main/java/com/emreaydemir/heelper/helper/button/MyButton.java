package com.emreaydemir.heelper.helper.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import com.emreaydemir.heelper.R;
import com.emreaydemir.heelper.constants.ConstantsColor;

public class MyButton extends AppCompatButton {




    private boolean isEnable = true;
    private float mRadius;
    private int mStrokeDashWidth, mStrokeDashGap;
    private int mStrokeColor = 0, mStrokeWidth, mBackgroundColor;

    private float mBgFactorRate = 1f;






    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyButton);
        mBackgroundColor = a.getColor(R.styleable.MyButton_mybtn_backgroundColor, getResources().getColor(ConstantsColor.colorPrimary));
        mRadius = a.getDimension(R.styleable.MyButton_mybtn_radius, 100);
        mStrokeDashGap = a.getInt(R.styleable.MyButton_mybtn_strokeDashGap, 0);
        mStrokeDashWidth = a.getInt(R.styleable.MyButton_mybtn_strokeDashWidth, 0);
        mStrokeWidth = a.getInt(R.styleable.MyButton_mybtn_strokeWidth, 0);
        mStrokeColor = a.getColor(R.styleable.MyButton_mybtn_strokeColor, mBackgroundColor);

        mBgFactorRate = a.getFloat(R.styleable.MyButton_mybtn_bgFactorRate, 1f);

        a.recycle();

        setAllCaps(false);

//        TypedArray a1 = getContext().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
//        Drawable mForegroundDrawable = a1.getDrawable(0);
//        setForeground(mForegroundDrawable);

        notifyChanges();
    }

    @Override
    public void setEnabled(boolean enabled) {
        isEnable = enabled;
        notifyChanges();
        super.setEnabled(enabled);
    }

    private void notifyChanges() {




        Float factor = 0.8f, factorStorke = 0.9f;

        if (!isEnable) {
            //handling for button disable state
            setAlpha(0.6f);
        }

        if (mStrokeColor == 0) {
            mStrokeColor = manipulateColor(mBackgroundColor, factorStorke);
        }

        Drawable pressed = getDrawable1(manipulateColor(mBackgroundColor, factor), mRadius);
        Drawable normal = getDrawable1(mBackgroundColor, mRadius);

        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed}, pressed);
        states.addState(new int[]{}, normal);
        setBackground(states);

    }

    public GradientDrawable getDrawable1(int backgroundColor, float radius) {

        int colors[] = {backgroundColor,
                manipulateColor(backgroundColor, mBgFactorRate)};

        GradientDrawable shape = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);

        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(radius);

        shape.setGradientType(GradientDrawable.LINEAR_GRADIENT);

        shape.setStroke(mStrokeWidth, mStrokeColor);
        if (mStrokeDashGap > 0 || mStrokeDashWidth > 0) {
            shape.setStroke(mStrokeWidth, mStrokeColor, mStrokeDashWidth, mStrokeDashGap);
        }

        return shape;
    }

    private int manipulateColor(int color, float factor) {
        //factor = 0.8f
        int a = Color.alpha(color);
        int r = Math.round(Color.red(color) * factor);
        int g = Math.round(Color.green(color) * factor);
        int b = Math.round(Color.blue(color) * factor);
        return Color.argb(a,
                Math.min(r, 255),
                Math.min(g, 255),
                Math.min(b, 255));
    }

    public void setBackgroundColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
        notifyChanges();
    }





    public void setCornerRadious(int cornerRadious) {
        mRadius = cornerRadious;
        notifyChanges();
    }

    public void setStrokeDashGap(int strokeDashGap) {
        mStrokeDashGap = strokeDashGap;
        notifyChanges();
    }

    public void setStrokeDashWidth(int strokeDashWidth) {
        mStrokeDashWidth = strokeDashWidth;
        notifyChanges();
    }

    public void setStrokeColor(int strokeColor) {
        mStrokeColor = strokeColor;
        notifyChanges();
    }

    public void setStrokeWidth(int strokeWidth) {
        mStrokeWidth = strokeWidth;
        notifyChanges();
    }

    public void setBgFactorRate(float bgFactorRate) {
        mBgFactorRate = bgFactorRate;
        notifyChanges();
    }
}