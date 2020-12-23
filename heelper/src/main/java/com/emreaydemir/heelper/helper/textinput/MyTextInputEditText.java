package com.emreaydemir.heelper.helper.textinput;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.emreaydemir.heelper.constants.ConstantsEditText;
import com.google.android.material.textfield.TextInputEditText;

public class MyTextInputEditText extends TextInputEditText {
    public MyTextInputEditText(@NonNull Context context) {
        super(context);
        init();
    }

    public MyTextInputEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextInputEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        Typeface customFont = Typeface.createFromAsset(getContext().getAssets(), ConstantsEditText.edtSemiBoldPath);
        setTypeface(customFont);
    }
}
