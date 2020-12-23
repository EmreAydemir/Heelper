package com.emreaydemir.heelperexample.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.emreaydemir.heelper.helper.textinputlayout.AddTextChanged;
import com.emreaydemir.heelper.helper.textinputlayout.MyTextInputLayout;
import com.emreaydemir.heelper.util.InputUtil;
import com.emreaydemir.heelperexample.R;
import com.emreaydemir.heelperexample.databinding.FTextinputBinding;
import com.emreaydemir.heelperexample.view.base.BaseFragment;
import com.emreaydemir.heelperexample.view.callback.IDetailF;
import com.emreaydemir.heelperexample.view.tempModel;
import com.emreaydemir.heelperexample.viewmodel.BlankViewModel;

public class TextInputF extends BaseFragment<BlankViewModel, FTextinputBinding> implements IDetailF {


    @Override
    protected Class<BlankViewModel> getViewModel() {
        return BlankViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.f_textinput;
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tempModel tempModel = new tempModel("Emre", "emreaydemir@payall.com.tr");

        dataBinding.txtTitle.setText(tempModel.getEmail());

        dataBinding.setHandler(this);



    }


    @Override
    public void onBtnCheckClick(View view) {

        if(edtControl()){
            Toast.makeText(getContext(), "Kontrol Başarılı!", Toast.LENGTH_SHORT).show();
        }

    }


    private boolean edtControl(){


        // Username
        if (InputUtil.checkAllEditTexts(dataBinding.edtUsername)) {
            if (!InputUtil.matchMinLength(dataBinding.edtUsername, 6)) {
                MyTextInputLayout.error(AddTextChanged.minLenght, getContext(), dataBinding.textinputlayoutUsername, dataBinding.edtUsername, "Kullanıcı adı 6 haneden az olamaz!", 6);
                return false;
            }
        } else {
            MyTextInputLayout.error(AddTextChanged.empty, getContext(), dataBinding.textinputlayoutUsername, dataBinding.edtUsername, "Kullanıcı adı boş olamaz!", 0);
            return false;
        }

        // Password
        if (InputUtil.checkAllEditTexts(dataBinding.edtPassword)) {
            if (!InputUtil.matchMinLength(dataBinding.edtPassword, 6)) {
                MyTextInputLayout.error(AddTextChanged.minLenght, getContext(), dataBinding.textinputlayoutPassword, dataBinding.edtPassword, "Şifre 6 haneden az olamaz!", 6);
                return false;
            }
        } else {
            MyTextInputLayout.error(AddTextChanged.empty, getContext(), dataBinding.textinputlayoutPassword, dataBinding.edtPassword, "Şifre boş olamaz!", 0);
            return false;
        }

        // Email
        if (InputUtil.checkAllEditTexts(dataBinding.edtEmail)) {
            if (!InputUtil.isValidEmail(dataBinding.edtEmail.getText().toString())) {
                MyTextInputLayout.error(AddTextChanged.validEmail, getContext(), dataBinding.textinputlayoutEmail, dataBinding.edtEmail, "Lütfen e-posta adresinizi doğru biçimde girin!", 0);
                return false;
            }
        } else {
            MyTextInputLayout.error(AddTextChanged.empty, getContext(), dataBinding.textinputlayoutEmail, dataBinding.edtEmail, "Email boş olamaz!", 0);
            return false;
        }

        return true;
    }





}
