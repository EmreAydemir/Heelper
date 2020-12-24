package com.emreaydemir.heelper.helper.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.emreaydemir.heelper.constants.ConstantsTextView;

public class MyTextViewRegular extends AppCompatTextView {

    public MyTextViewRegular(Context context) {
        super(context);
        init();
    }

    public MyTextViewRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextViewRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        // My Font -> assets - fonts
        Typeface customFont = Typeface.createFromAsset(getContext().getAssets(), ConstantsTextView.txtRegularPath);
        setTypeface(customFont);
        setIncludeFontPadding(true);
    }
}