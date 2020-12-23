package com.emreaydemir.heelper;

import android.content.Context;

import com.emreaydemir.heelper.constants.ConstantsButton;

public class HeelperButton {

    // Fonts
    public static void setBtnFonts(String regularPath, String boldPath, String semiBoldPath){

        ConstantsButton.btnRegularPath = regularPath;
        ConstantsButton.btnBoldPath = boldPath;
        ConstantsButton.btnSemiBoldPath = semiBoldPath;
    }
}
