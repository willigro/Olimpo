package com.rittamann.oview.toolbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class OToolbar {

    @SuppressWarnings("ConstantConditions")
    public static void showBackArrow(AppCompatActivity activity) {
        if (toolbarIsValid(activity))
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @SuppressWarnings("ConstantConditions")
    public static void hideBackArrow(AppCompatActivity activity) {
        if (toolbarIsValid(activity))
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public static void setActionbar(ActionBar supportActionBar, String tittle) {
        if (supportActionBar != null) {
            supportActionBar.setTitle(tittle);
            supportActionBar.setSubtitle(null);
        }
    }

    @SuppressWarnings("ConstantConditions")
    public static void setTitle(AppCompatActivity activity, String title) {
        if (toolbarIsValid(activity) && title != null) {
            activity.getSupportActionBar().setTitle(title);
        }
    }

    private static boolean toolbarIsValid(AppCompatActivity activity) {
        return activity != null && activity.getSupportActionBar() != null;
    }
}
