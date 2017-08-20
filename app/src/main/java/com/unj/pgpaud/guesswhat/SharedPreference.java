package com.unj.pgpaud.guesswhat;

/**
 * Created by Muhammad Ardiansyah on 12/18/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    public SharedPreference(){
    }

    public void setPreferences(Context context, String key, int value) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Preference", Context.MODE_PRIVATE).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void clearPreferences(Context context, String key){
        SharedPreferences.Editor editor = context.getSharedPreferences("Preference", Context.MODE_PRIVATE).edit();
        editor.remove(key);
        editor.commit();
    }

    public  int getPreferences(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences("Preference",	Context.MODE_PRIVATE);
        int position = prefs.getInt(key, 0);
        return position;
    }
}