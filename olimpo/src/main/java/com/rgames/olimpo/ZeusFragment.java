package com.rgames.olimpo;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public class ZeusFragment {

    public static void nav(Context context, int container, Fragment fragment) {
        if (fragment == null) return;
        try {
            ((AppCompatActivity) context).getFragmentManager()
                    .beginTransaction()
                    .replace(container, fragment, fragment.getClass().getName()).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
