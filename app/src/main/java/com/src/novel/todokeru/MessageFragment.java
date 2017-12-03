package com.src.novel.todokeru;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;
import com.src.novel.todokeru.databinding.FragmentMessageBinding;
import com.src.novel.todokeru.model.Message;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MessageFragment extends BaseFragment {

    FragmentMessageBinding mBinding;
    private MessageAdapter mAdapter;
    private Message mMessage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_message, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(API.BASE_URL).build();

        API api = retrofit.create(API.class);
        api.getMessage(Prefs.getFloat(Const.USER_ID.name(), -1)).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(@NonNull Call<Message> call, @NonNull Response<Message> response) {
                mMessage = response.body();
                mAdapter = new MessageAdapter(mMessage);
                mBinding.list.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(@NonNull Call<Message> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), "通信エラー", Toast.LENGTH_SHORT).show();
            }
        });
        mBinding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}