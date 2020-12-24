package com.emreaydemir.heelperexample;

import android.app.Application;
import android.provider.SyncStateContract;

import com.emreaydemir.heelper.Heelper;
import com.emreaydemir.heelper.HeelperButton;
import com.emreaydemir.heelper.HeelperEditText;
import com.emreaydemir.heelper.HeelperTextView;

public class MyApp extends Application {

    String poppinsRegular = "fonts/Gilroy-Regular.ttf";
    String poppinsSemiBold = "fonts/Gilroy-SemiBold.ttf";
    String poppinsBold = "fonts/Gilroy-Bold.ttf";



    @Override
    public void onCreate() {

        super.onCreate();


        Heelper.init(true, true);

        // TO DO Glide veya WordToSpan tarzında olacak

        HeelperButton.setBtnFonts(poppinsRegular, poppinsBold, poppinsSemiBold);
        HeelperEditText.setEdtFonts(poppinsRegular, poppinsBold, poppinsSemiBold);
        HeelperTextView.setTxtFonts(poppinsRegular, poppinsBold, poppinsSemiBold);
        Heelper.setColors(R.color.earswan);

    }


}
