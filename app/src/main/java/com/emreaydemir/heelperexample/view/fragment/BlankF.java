package com.emreaydemir.heelperexample.view.fragment;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.emreaydemir.heelperexample.R;
import com.emreaydemir.heelperexample.databinding.FEdittextBinding;
import com.emreaydemir.heelperexample.view.base.BaseFragment;
import com.emreaydemir.heelperexample.viewmodel.BlankViewModel;



public class BlankF extends BaseFragment<BlankViewModel, FEdittextBinding> {
    
    // Definition


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
        init();
    }
    
    private void init(){
        
    }
    
    // Listeners
    
    
    // ViewModel Methods
    
    
    // Other Methods
    
    
    // Bundle, Args, SharedPref

   private Bundle setBundle(String fefa) {
       Bundle bundle = new Bundle();
       bundle.putSerializable("fefa", fefa);
       return bundle;
   }

    
}
