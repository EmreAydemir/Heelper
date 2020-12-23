package com.emreaydemir.heelper.util;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.LifecycleOwner;

public class InputUtil {

    private static final boolean YES = true;
    private static final boolean NO = false;

    public static boolean checkAllEditTexts(EditText... editTexts) {
        for (EditText edit : editTexts) {
            if (edit == null || !(edit.getText().toString().trim().length() > 0)) {
                return NO;
            }
        }
        return YES;
    }

    public static boolean checkAllEditTexts(Context context, View view, String msg, EditText... editTexts) {
        if (checkAllEditTexts(editTexts)) {
            return YES;
        } else {

//                    showSnackbar(context, view, value);

            return NO;
        }
    }

    public static void showToast(Context context, String msg) {
     //   MyToast.makeText(context, msg);
    }

    public static void showSnackbar(Context context, View view, String msg) {
     //   MySnackBar.make(context, view, msg);
    }


    public static boolean isValidEmail(CharSequence target) {
        if (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()) {
            return YES;
        } else {

   //         showToast(context, value);


            return NO;
        }
    }

    public static boolean matchMinLength(EditText editText, int length) {
        String content = removeBlankSpace(editText.getText().toString());
        return content.length() >= length ? YES : NO;
    }

    public static boolean matchMinLength(Context context, EditText editText, int length, String msg) {
        if (matchMinLength(editText, length)) {
            return YES;
        } else {
            showToast(context, msg);
            return NO;
        }
    }

    public static String removeBlankSpace(String value) {
        value = value.replace(" ", "");
        return value;
    }

    public static void edtToLowercase(EditText edt) {
        edt.setFilters(new InputFilter[]{
                new InputFilter.AllCaps() {
                    @Override
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        return String.valueOf(source).toLowerCase();
                    }

                }
        });


    }

}
