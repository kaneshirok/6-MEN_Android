package com.src.novel.todokeru;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pixplicity.easyprefs.library.Prefs;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_FINE_LOCATION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.plant(new Timber.DebugTree());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Transit.map(this);

        float id = Prefs.getFloat(Const.USER_ID.name(), -1);
        if(id == -1){
            startActivity(new Intent(this, SplashActivity.class));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the contacts-related task you need to do.
                    Transit.map(this);
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    finish();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
