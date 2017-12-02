package com.src.novel.todokeru;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.src.novel.todokeru.databinding.FragmentSettingBinding;


public class SettingFragment extends BaseFragment {

    FragmentSettingBinding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Picasso.with(getContext()).load("https://www.pakutaso.com/assets_c/2016/02/model_akanesaya-thumb-320x320-20922.jpg")
                .transform(new PicassoTransform()).into(mBinding.image);
    }
}