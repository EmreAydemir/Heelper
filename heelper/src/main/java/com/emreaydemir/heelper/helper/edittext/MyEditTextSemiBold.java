package com.emreaydemir.heelper.helper.edittext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.emreaydemir.heelper.constants.ConstantsButton;
import com.emreaydemir.heelper.helper.edittext.clearable.ClearableEditText;

public class MyEditTextSemiBold extends ClearableEditText {

    public MyEditTextSemiBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface customFont = Typeface.createFromAsset(context.getAssets(), ConstantsButton.btnSemiBoldPath);
        setTypeface(customFont);
    }
}
