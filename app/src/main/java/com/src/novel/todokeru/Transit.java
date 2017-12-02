package com.src.novel.todokeru;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by pdc-k-kamiya on 2017/12/02.
 */

public class Transit {

    public static void setting(FragmentActivity activity){
        transit(activity, new SettingFragment());
    }

    public static void message(FragmentActivity activity){
        transit(activity, new MessageFragment());
    }

    public static void search(FragmentActivity activity){
        transit(activity, new SearchFragment());
    }

    public static void favorite(FragmentActivity activity){
        transit(activity, new FavoriteFragment());
    }

    public static void transit(FragmentActivity activity, Fragment fragment){
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.container, fragment).commit();
    }
}
