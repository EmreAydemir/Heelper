package com.emreaydemir.heelper.Util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import com.digitalplanet.staff.helper.MySnackBar;
import com.digitalplanet.staff.helper.MyToast;
import com.digitalplanet.staff.helper.SharedViewModelHelper;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Util {


    public static void bottomSheetStateExpanded(Dialog dialogFragment) {
        dialogFragment.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                BottomSheetDialog d = (BottomSheetDialog) dialog;
                View bottomSheetInternal = d.findViewById(com.google.android.material.R.id.design_bottom_sheet);
                BottomSheetBehavior.from(bottomSheetInternal).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

    }

    // System UI Show / Hide


    public static void hideSystemUI(Activity activity) {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = activity.getWindow().getDecorView();
        // decorView.setFitsSystemWindows(true);
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }


    public static void showSystemUI(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        //    decorView.setFitsSystemWindows(false);
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }


    private static final boolean YES = true;
    private static final boolean NO = false;


    public static boolean isInternetAvailable(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
        } else {

            return NO;
        }
    }

//    public static boolean isInternetAvailableWithMsg(Context context) {
//        if (isInternetAvailable(context)) {
//            return YES;
//        } else {
//            showToast(context, context.getResources().getString(R.string.internetconnecion));
//            return NO;
//        }
//    }

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
            SharedViewModelHelper.getViewModel().error_check_all_input.observe((LifecycleOwner) context, value -> {
                if (value != null)
                    showSnackbar(context, view, value);
                 //   showToast(context, value);
            });
            return NO;
        }
    }

    public static void showToast(Context context, String msg) {
        MyToast.makeText(context, msg);
    }

    public static void showSnackbar(Context context, View view, String msg) {
        MySnackBar.make(context, view, msg);
    }


    public static boolean isValidEmail(Context context, View view, String msg, CharSequence target) {
        if (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()) {
            return YES;
        } else {
            SharedViewModelHelper.getViewModel().error_email_format.observe((LifecycleOwner) context, value -> {
                if (value != null)
                    showSnackbar(context, view, value);
                   // showToast(context, value);
            });

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


    public static void changeTextColor(TextView txt, int colorRes) {
        txt.setTextColor(txt.getContext().getResources().getColor(colorRes));
    }


    public static void changeColor(ImageView imageView, int colorRes) {
        imageView.setColorFilter(imageView.getContext().getResources().getColor(colorRes), PorterDuff.Mode.SRC_ATOP);
    }

    public static void changeDrawable(Context context, View view, int drawableRes) {

        view.setBackground(ContextCompat.getDrawable(context, drawableRes));
    }


    public static String getAndroidID(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }


}
