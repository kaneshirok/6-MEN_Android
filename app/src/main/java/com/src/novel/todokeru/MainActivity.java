package com.src.novel.todokeru;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pixplicity.easyprefs.library.Prefs;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.plant(new Timber.DebugTree());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Transit.map(this);

        int id = Prefs.getInt(Const.USER_ID.name(), -1);
        if(id == -1){
            startActivity(new Intent(this, SplashActivity.class));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
