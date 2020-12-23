package com.emreaydemir.heelper.helper.edittext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.emreaydemir.heelper.constants.ConstantsButton;
import com.emreaydemir.heelper.helper.button.MyButton;
import com.emreaydemir.heelper.helper.edittext.clearable.ClearableEditText;

public class MyEditTextRegular extends ClearableEditText {

    public MyEditTextRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface customFont = Typeface.createFromAsset(context.getAssets(), ConstantsButton.btnRegularPath);
        setTypeface(customFont);
    }
}
