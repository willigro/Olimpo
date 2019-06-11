package com.rittamann.ofragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class OFragment {

    /**
     * Perform navigation between screens
     * Using the name of fragment in tag
     * */
    public static void replace(Context context, int container, Fragment fragment) throws NullPointerException {
        if (fragment == null) throw new NullPointerException("Fragment null. Please inform a valid instance of the fragment to perform the navigation.");
        ((AppCompatActivity) context).getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment, fragment.getClass().getName()).commit();
    }
}
