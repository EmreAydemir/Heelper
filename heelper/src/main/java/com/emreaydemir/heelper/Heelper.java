package com.emreaydemir.heelper;

import androidx.appcompat.app.AppCompatDelegate;

import com.emreaydemir.heelper.constants.ConstantsColor;

import timber.log.Timber;

public class Heelper {


    public static void init(boolean heelperLog, boolean vector) {
        if (heelperLog) timber();
        if (vector) vector();

    }


    public static void timber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static void vector() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


    public static void setColors(int colorPrimary){
        ConstantsColor.colorPrimary = colorPrimary;
    }

}
