package com.src.novel.todokeru;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class BaseFragment extends Fragment {

    public void onCurrentFragment(){}
    /**
     * バックスタック変更時のリスナ
     */
    private FragmentManager.OnBackStackChangedListener mBackStackChangedListener = new FragmentManager.OnBackStackChangedListener() {
        @Override
        public void onBackStackChanged() {
            FragmentManager fm = getFragmentManager();
            Fragment curFragment = fm.findFragmentById(R.id.container);
            if (BaseFragment.this == curFragment) {
                onCurrentFragment();
            }
        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getFragmentManager().addOnBackStackChangedListener(mBackStackChangedListener);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getFragmentManager().removeOnBackStackChangedListener(mBackStackChangedListener);
        mBackStackChangedListener = null;
    }
}
