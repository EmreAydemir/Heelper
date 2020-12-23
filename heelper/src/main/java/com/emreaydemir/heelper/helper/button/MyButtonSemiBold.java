package com.emreaydemir.heelper.helper.button;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.emreaydemir.heelper.constants.ConstantsButton;

public class MyButtonSemiBold extends MyButton{
    public MyButtonSemiBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface customFont = Typeface.createFromAsset(getContext().getAssets(), ConstantsButton.btnSemiBoldPath);
        setTypeface(customFont);

    }
}
