package com.src.novel.todokeru;


import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.src.novel.todokeru.databinding.FragmentSearchBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment {

    FragmentSearchBinding mBinding;
    FavoriteAdapter mAdapter;

    private static final String[] COUNTRIES = {
            "#ヒマ",
            "#お腹すいた",
            "#はしゃぎたい",
            "#楽しい！",
            "#つかれた",
            "#うれしい",
            "#困っている",

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAdapter = new FavoriteAdapter();
        mBinding.toolbar.inflateMenu(R.menu.menu_search);

        SearchView searchView = (SearchView) mBinding.toolbar.getMenu().findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        EditText searchEditText = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.white));
        searchEditText.setHintTextColor(getResources().getColor(R.color.white));
        mBinding.listView.setAdapter(mAdapter);
    }
}
