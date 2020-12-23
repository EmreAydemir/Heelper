package com.emreaydemir.heelperexample;

import android.app.Application;
import android.provider.SyncStateContract;

import com.emreaydemir.heelper.Heelper;
import com.emreaydemir.heelper.HeelperButton;

public class MyApp extends Application {

    String poppinsRegular = "fonts/Gilroy-Regular.ttf";
    String poppinsSemiBold = "fonts/Gilroy-SemiBold.ttf";
    String poppinsBold = "fonts/Gilroy-Bold.ttf";



    @Override
    public void onCreate() {

        super.onCreate();


        Heelper.init(true, false);
        HeelperButton.setFonts(poppinsSemiBold);
        HeelperButton.setBtnFonts(poppinsRegular, poppinsBold, poppinsSemiBold);
        Heelper.setColors(R.color.earswan);

    }


}
