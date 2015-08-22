package com.parent.michal.parnets;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by GRMICHAL on 8/19/2015.
 */
public class SharedHandler {
    // for save data in the shared preference file...
    // we need the context in order to use getSharedPreferences (Activity
    // method)
    public static void save(String key, String value, String filename,
                            Context context) {

        SharedPreferences sp = context.getSharedPreferences(filename, 0);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.commit();

    }

    public static String get(String key, String filename, Context context) {
        SharedPreferences sp = context.getSharedPreferences(filename, 0);
        String str = sp.getString(key, "");
        return str;
    }
}
