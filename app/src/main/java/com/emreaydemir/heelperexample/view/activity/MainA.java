package com.emreaydemir.heelperexample.view.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.emreaydemir.heelper.HeelperLog;
import com.emreaydemir.heelperexample.R;
import com.emreaydemir.heelperexample.databinding.AMainBinding;
import com.emreaydemir.heelperexample.view.base.BaseActivity;

public class MainA extends BaseActivity<AMainBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.a_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        HeelperLog.e("Error");
        HeelperLog.d("Debug");



    }
}