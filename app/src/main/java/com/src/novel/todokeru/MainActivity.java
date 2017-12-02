package com.src.novel.todokeru;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.src.novel.todokeru.databinding.ActivityMainBinding;

import java.util.UUID;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    // Local Bluetooth adapter
    private BluetoothAdapter mBluetoothAdapter;

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

    @Override
    protected void onPause() {
        super.onPause();
        mBluetoothAdapter.cancelDiscovery();
    }
}
