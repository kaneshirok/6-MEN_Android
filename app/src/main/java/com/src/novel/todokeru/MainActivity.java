package com.src.novel.todokeru;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.src.novel.todokeru.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // 設定クリック
        binding.flSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transit.setting(MainActivity.this);
                binding.flMenu.close(true);
            }
        });

        // メッセージクリック
        binding.flMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transit.message(MainActivity.this);
                binding.flMenu.close(true);
            }
        });

        // 検索クリック
        binding.flSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transit.search(MainActivity.this);
                binding.flMenu.close(true);
            }
        });

        // お気に入りクリック
        binding.flFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transit.favorite(MainActivity.this);
                binding.flMenu.close(true);
            }
        });

        Transit.search(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
