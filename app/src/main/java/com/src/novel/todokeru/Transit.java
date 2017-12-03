package com.src.novel.todokeru;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.src.novel.todokeru.model.Datum;

/**
 * Created by pdc-k-kamiya on 2017/12/02.
 */

public class Transit {

    public static void setting(FragmentActivity activity, Datum datum){
        Bundle bundle = new Bundle();
        bundle.putSerializable(Datum.class.getName(), datum);
        transit(activity, new SettingFragment(), bundle);
    }

    public static void message(FragmentActivity activity){
        transit(activity, new MessageFragment(), null);
    }

    public static void message(FragmentActivity activity, Bundle bundle){
        transit(activity, new FavoriteFragment(), bundle);
    }

    public static void search(FragmentActivity activity){
        transit(activity, new SearchFragment(), null);
    }

    public static void search(FragmentActivity activity, Bundle bundle){
        transit(activity, new FavoriteFragment(), bundle);
    }

    public static void favorite(FragmentActivity activity){
        transit(activity, new FavoriteFragment(), null);
    }

    public static void favorite(FragmentActivity activity, Bundle bundle){
        transit(activity, new FavoriteFragment(), bundle);
    }

    public static void map(FragmentActivity activity){
        map(activity, null);
    }

    public static void map(FragmentActivity activity, Bundle bundle){
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        try{
            transaction.add(R.id.container, new MapFragment()).commit();
        } catch (IllegalStateException e){
            try{
                transaction.add(R.id.container, new MapFragment()).commitAllowingStateLoss();
            } catch (Exception e1){

            }

        }

    }

    public static void transit(FragmentActivity activity, Fragment fragment, Bundle bundle){

        // フラグメントに引き渡すデータが存在する場合に引き渡すデータを設定
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.add(R.id.container, fragment).addToBackStack(null).commit();
    }
}
