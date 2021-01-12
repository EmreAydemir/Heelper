package com.emreaydemir.heelper;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.ActionOnlyNavDirections;

import com.emreaydemir.heelper.constants.ConstantsColor;
import com.emreaydemir.heelper.helper.SharedPref;

import timber.log.Timber;
import zerobranch.androidremotedebugger.AndroidRemoteDebugger;

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


    public static void setColors(int colorPrimary) {
        ConstantsColor.colorPrimary = colorPrimary;
    }


    public static void androidRemoteDebugger(Context context, boolean notifications, int port) {

//        AndroidRemoteDebugger.Builder androidRemoteDebugger = new AndroidRemoteDebugger.Builder(context);
//
//        androidRemoteDebugger.enabled(true);
//        if (notifications) androidRemoteDebugger.disableNotifications();
//        androidRemoteDebugger.port(port);
//        androidRemoteDebugger.build();

        if (notifications) {
            AndroidRemoteDebugger.init(
                    new AndroidRemoteDebugger.Builder(context)
                            .enabled(true)
//                        .disableInternalLogging()
//                        .enableDuplicateLogging()
//                        .disableJsonPrettyPrint()
//                        .disableNotifications()
//                        .excludeUncaughtException()
                            .port(port)
                            .build()
            );
        }
        else{
            AndroidRemoteDebugger.init(
                    new AndroidRemoteDebugger.Builder(context)
                            .enabled(true)
//                        .disableInternalLogging()
//                        .enableDuplicateLogging()
//                        .disableJsonPrettyPrint()
                        .disableNotifications()
//                        .excludeUncaughtException()
                            .port(port)
                            .build()
            );
        }
    }

    public static void initSharedPref(Context context){
        SharedPref.init(context);
    }

}
