package com.src.novel.todokeru;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.src.novel.todokeru.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        // 設定クリック
//        binding.setting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Transit.setting(MainActivity.this);
//            }
//        });
//
//        // メッセージクリック
//        binding.message.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Transit.message(MainActivity.this);
//            }
//        });
//
//        // 検索クリック
//        binding.search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Transit.setting(MainActivity.this);
//            }
//        });
//
//        // お気にい入り
//        binding.favorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Transit.favorite(MainActivity.this);
//            }
//        });

        // 設定クリック
        binding.flSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transit.setting(MainActivity.this);
            }
        });

        // メッセージクリック
        binding.flMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transit.message(MainActivity.this);
            }
        });

        // 検索クリック
        binding.flSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transit.search(MainActivity.this);
            }
        });

        // お気に入りクリック
        binding.flFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transit.favorite(MainActivity.this);
            }
        });
    }
}
