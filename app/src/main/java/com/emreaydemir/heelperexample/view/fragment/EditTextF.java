package com.emreaydemir.heelperexample.view.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.emreaydemir.heelperexample.R;
import com.emreaydemir.heelperexample.databinding.FButtonBinding;
import com.emreaydemir.heelperexample.databinding.FEdittextBinding;
import com.emreaydemir.heelperexample.view.base.BaseFragment;
import com.emreaydemir.heelperexample.viewmodel.BlankViewModel;

public class EditTextF extends BaseFragment<BlankViewModel, FEdittextBinding> {


    @Override
    protected Class<BlankViewModel> getViewModel() {
        return BlankViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.f_edittext;
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





    }
}