package com.src.novel.todokeru;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pixplicity.easyprefs.library.Prefs;
import com.src.novel.todokeru.databinding.ActivitySplashBinding;
import com.src.novel.todokeru.model.User;
import com.src.novel.todokeru.post.UserPost;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final ActivitySplashBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        binding.finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(binding.id.getText() == null || binding.id.getText().toString().isEmpty()){
                    return;
                }

                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(API.BASE_URL).build();
                API api = retrofit.create(API.class);
                UserPost userPost = new UserPost();
                userPost.setUser_name(binding.id.getText().toString());
                userPost.setUser_image("https://www.pakutaso.com/assets_c/2016/12/modellistup-thumb-600x600-28895.jpg");
                Timber.d("JSON = " + userPost.toJson());
                api.postTop(userPost).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        int id = response.body().getData().get(0).getUserId();
                        Prefs.putFloat(Const.USER_ID.name(), id);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
                finish();
            }
        });
    }
}
