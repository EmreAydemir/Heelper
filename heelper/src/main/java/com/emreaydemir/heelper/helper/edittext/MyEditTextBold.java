package com.emreaydemir.heelper.helper.edittext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.emreaydemir.heelper.constants.ConstantsButton;
import com.emreaydemir.heelper.helper.edittext.clearable.ClearableEditText;

public class MyEditTextBold extends ClearableEditText {

    public MyEditTextBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface customFont = Typeface.createFromAsset(context.getAssets(), ConstantsButton.btnBoldPath);
        setTypeface(customFont);
    }
}
