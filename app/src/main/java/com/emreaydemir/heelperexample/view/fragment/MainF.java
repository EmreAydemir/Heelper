package com.emreaydemir.heelperexample.view.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.emreaydemir.heelper.util.NavigateUtil;
import com.emreaydemir.heelperexample.R;
import com.emreaydemir.heelperexample.databinding.FMainBinding;
import com.emreaydemir.heelperexample.view.base.BaseFragment;
import com.emreaydemir.heelperexample.viewmodel.BlankViewModel;


public class MainF extends BaseFragment<BlankViewModel, FMainBinding> {



    @Override
    protected Class<BlankViewModel> getViewModel() {
        return BlankViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.f_main;
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        dataBinding.btnTextInputF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigateUtil.fragmentNavigate(getView(), R.id.action_mainF_to_textinputF);
            }
        });



        dataBinding.btnButtonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigateUtil.fragmentNavigate(getView(), R.id.action_mainF_to_buttonF);
            }
        });


    }
}