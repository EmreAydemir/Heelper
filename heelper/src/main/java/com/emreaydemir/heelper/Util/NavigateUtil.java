package com.emreaydemir.heelper.Util;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class NavigateUtil {


    private static NavController navController;
    private static Bundle bundle;

    public static void fragmentNavigate(View view, int action) {

        navController = Navigation.findNavController(view);
        if (navController != null) {
            navController.navigate(action, null);
        }
    }

    public static void imgBack(View view, ImageView imgBack) {

        imgBack.setOnClickListener(v -> navigateUp(view));
    }

    public static void navigateUp(View view) {
        navController = Navigation.findNavController(view);
        navController.navigateUp();
    }




    public static void fragmentNavigate(View view, int action, Bundle bundle) {
        if (view != null) {
            navController = Navigation.findNavController(view);
            navController.navigate(action, bundle, null);
        }
    }


    public static void changeFragment(Fragment fragment, Context context, int layout) {
        FragmentTransaction fragmentTransaction = ((FragmentActivity) context)
                .getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(layout, fragment);
        fragmentTransaction.commit();
    }


    public static void changeFragment2(Fragment fragment, Context context, int layout, String Tag) {

        FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment frStack = manager.findFragmentByTag(Tag);


        if (frStack == null) {
            transaction.replace(layout, fragment, Tag);
        } else {
            transaction.replace(layout, frStack);
        }
        transaction.addToBackStack(null);
        transaction.commit();


    }


}
