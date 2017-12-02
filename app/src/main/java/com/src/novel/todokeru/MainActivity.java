package com.src.novel.todokeru;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.plant(new Timber.DebugTree());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Transit.map(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
