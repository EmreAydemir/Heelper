package com.emreaydemir.heelper;

import android.content.Context;

import com.emreaydemir.heelper.constants.ConstantsButton;
import com.emreaydemir.heelper.constants.ConstantsFonts;

public class HeelperButton {


    public static void setFonts(String myTextInputEditTextFontPath){
        ConstantsFonts.myTextInputEditTextFontPath = myTextInputEditTextFontPath;
    }

    public static void setBtnFonts(String regularPath, String boldPath, String semiBoldPath){

        ConstantsButton.btnRegularPath = regularPath;
        ConstantsButton.btnBoldPath = boldPath;
        ConstantsButton.btnSemiBoldPath = semiBoldPath;
    }
}
