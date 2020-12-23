package com.emreaydemir.heelper.helper.button;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.emreaydemir.heelper.constants.ConstantsButton;

public class MyButtonRegular extends MyButton{
    public MyButtonRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface customFont = Typeface.createFromAsset(getContext().getAssets(), ConstantsButton.btnRegularPath);
        setTypeface(customFont);

    }
}
