package com.emreaydemir.heelper.helper.button;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.emreaydemir.heelper.constants.ConstantsButton;

public class MyButtonBold extends MyButton{
    public MyButtonBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface customFont = Typeface.createFromAsset(getContext().getAssets(), ConstantsButton.btnBoldPath);
        setTypeface(customFont);

    }
}
