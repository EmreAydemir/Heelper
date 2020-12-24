package com.emreaydemir.heelperexample.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.emreaydemir.heelper.helper.textview.WordToSpan;
import com.emreaydemir.heelperexample.R;
import com.emreaydemir.heelperexample.databinding.FEdittextBinding;
import com.emreaydemir.heelperexample.databinding.FTextviewBinding;
import com.emreaydemir.heelperexample.view.base.BaseFragment;
import com.emreaydemir.heelperexample.viewmodel.BlankViewModel;

public class TextViewF extends BaseFragment<BlankViewModel, FTextviewBinding> {


    @Override
    protected Class<BlankViewModel> getViewModel() {
        return BlankViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.f_textview;
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String earswan = "Kaydolarak, Hizmet Şartlarını okuduğunuzu ve kabul ettiğinizi belirtirsiniz.";

        String myText = "I know http://just.com/anu how to @whisper, And I #know just #how to cry,I know just @where to anu@find.com the answers";

        WordToSpan wordToSpan = new WordToSpan();
        wordToSpan.setColorTAG(Color.GREEN)
                .setColorURL(Color.MAGENTA)
                .setColorPHONE(Color.RED)
                .setColorMAIL(getResources().getColor(R.color.md_blue_300))
                .setColorMENTION(getResources().getColor(R.color.md_yellow_A700))
                .setUnderlineURL(true)
                .setLink(myText)
                .into(dataBinding.txtLink)
                .setClickListener(new WordToSpan.ClickListener() {
                    @Override
                    public void onClick(String type, String text) {
                        // type: "tag", "mail", "url", "phone", "mention" or "custom"
                        Toast.makeText(getContext(), "Type: " + type + "\nText: " + text, Toast.LENGTH_LONG).show();
                    }
                });


        WordToSpan link = new WordToSpan();
        link.setColorCUSTOM(getResources().getColor(R.color.link_blue))
                .setMyLink(earswan, "Hizmet Şartlarını")
                .into(dataBinding.txtEarswanlink)
                .setClickListener((type, text) -> {
                    // type: "tag", "mail", "url", "phone", "mention", "custom", "link"
                    Toast.makeText(getContext(), "Type: " + type + "\nText: " + text, Toast.LENGTH_LONG).show();
                });


    }
}








