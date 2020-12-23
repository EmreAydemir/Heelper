package com.emreaydemir.heelper.helper.textinputlayout;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.emreaydemir.heelper.R;
import com.emreaydemir.heelper.util.InputUtil;
import com.google.android.material.textfield.TextInputLayout;

public class MyTextInputLayout extends TextInputLayout {
    public MyTextInputLayout(@NonNull Context context) {
        super(context);
    }

    public MyTextInputLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextInputLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static void error(addTextChanged addTextChanged,
                             Context context,
                             MyTextInputLayout layout,
                             MyTextInputEditText editText,
                             String errorMessage,
                             int minLenght) {

        errorVisible(context, layout, editText, errorMessage);

        switch (addTextChanged) {
            case minLenght:
                addTextChanged_minLenght(context, layout, editText, errorMessage, minLenght);
                break;
            case empty:
                addTextChanged_empty(context, layout, editText, errorMessage);
                break;
            case validEmail:
                addTextChanged_validEmail(context, layout, editText, errorMessage);
                break;
        }

    }


    public static void errorVisible(Context context, MyTextInputLayout layout, MyTextInputEditText editText, String errorMessage) {
        layout.setErrorEnabled(true);
        layout.setError(errorMessage);
        layout.setBoxStrokeWidth(3);
        editText.setBackground(context.getResources().getDrawable(R.drawable.edt_bg_error));

    }

    public static void errorGone(Context context, MyTextInputLayout layout, MyTextInputEditText editText) {
        layout.setErrorEnabled(false);
        layout.setBoxStrokeWidth(0);
        editText.setBackground(context.getResources().getDrawable(R.drawable.edt_bg));
    }


    public static void addTextChanged_minLenght(Context context, MyTextInputLayout layout, MyTextInputEditText editText, String errorMessage, int minLenght) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() < minLenght) {
                    errorVisible(context, layout, editText, errorMessage);
                } else {
                    errorGone(context, layout, editText);
                }
            }
        });
    }


    public static void addTextChanged_empty(Context context, MyTextInputLayout layout, MyTextInputEditText editText, String errorMessage) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if (TextUtils.isEmpty(s.toString().trim())) {
                    errorVisible(context, layout, editText, errorMessage);
                } else {
                    errorGone(context, layout, editText);
                }

            }
        });
    }


    public static void addTextChanged_validEmail(Context context, MyTextInputLayout layout, MyTextInputEditText editText, String errorMessage) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if (!InputUtil.isValidEmail(s.toString())) {
                    errorVisible(context, layout, editText, errorMessage);
                } else {
                    errorGone(context, layout, editText);
                }

            }
        });
    }


}
