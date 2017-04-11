package com.kingwag.sharedreview;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * Created by kingwag on 2016/11/24.
 */

public class PreferencesUtil {
    public static final SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    public static void putString(Context context,String key,String data){
        SharedPreferences preferences = getPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, data);
        editor.commit();
    }
    public static String getString(Context context,String key){
        SharedPreferences preferences = getPreferences(context);
        String result = preferences.getString(key, "");
        return result;
    }
}
