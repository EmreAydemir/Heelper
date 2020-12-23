package com.emreaydemir.heelper.helper.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import com.emreaydemir.heelper.R;
import com.emreaydemir.heelper.constants.ConstantsButton;
import com.emreaydemir.heelper.constants.ConstantsColor;

public class MyButtonBold extends MyButton {

    public MyButtonBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface customFont = Typeface.createFromAsset(context.getAssets(), ConstantsButton.btnBoldPath);
        setTypeface(customFont);
    }
}
