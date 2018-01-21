package com.keyfalcon.blockchain.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shylesh on 19-Jan-18.
 */

public class Pref {
    public static final String SHARED_PREF = "com.keyfalcon.blockchain";
    private Context mContext;

    public Pref(Context context) {
        this.mContext = context;
    }

    public String getString(String key) {
        SharedPreferences settings = mContext.getSharedPreferences(
                SHARED_PREF, 0);
        try {
            return settings.getString(key, "");
        } catch (Exception e) {
            return "";
        }
    }

    public int getInt(String key) {
        SharedPreferences settings = mContext.getSharedPreferences(
                SHARED_PREF, 0);
        try {
            return settings.getInt(key, 0);
        } catch (Exception e) {
            return 0;
        }
    }

    public float getFloat(String key) {

        SharedPreferences settings = mContext.getSharedPreferences(
                SHARED_PREF, 0);
        try {

            return settings.getFloat(key, 0.0f);
        } catch (Exception e) {
            return 0;
        }
    }

    public long getLong(String key) {
        SharedPreferences settings = mContext.getSharedPreferences(
                SHARED_PREF, 0);
        try {
            return settings.getLong(key, 0);
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean getBoolean(String key) {
        SharedPreferences settings = mContext.getSharedPreferences(
                SHARED_PREF, 0);
        try {
            return settings.getBoolean(key, false);
        } catch (Exception e) {
            return false;
        }
    }

    public void put(String key, String value) {
        SharedPreferences settings = mContext.getSharedPreferences(
                SHARED_PREF, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void put(String key, float value) {
        SharedPreferences settings = mContext.getSharedPreferences(
                SHARED_PREF, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public void put(String key, long value) {
        SharedPreferences settings = mContext.getSharedPreferences(
                SHARED_PREF, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public void put(String key, int value) {
        SharedPreferences settings = mContext.getSharedPreferences(
                SHARED_PREF, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void put(String key, boolean value) {
        SharedPreferences settings = mContext.getSharedPreferences(
                SHARED_PREF, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void remove(String key) {
        SharedPreferences settings = mContext.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        settings.edit().remove(key).commit();
    }

    public void clear() {
        SharedPreferences settings = mContext.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        settings.edit().clear().commit();
    }
}
