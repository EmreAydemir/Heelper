package com.emreaydemir.heelperexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.emreaydemir.heelper.LogDebug;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogDebug.d("World");


    }
}