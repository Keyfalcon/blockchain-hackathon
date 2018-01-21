package com.keyfalcon.blockchain;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.keyfalcon.blockchain.helper.DbHelper;
import com.keyfalcon.blockchain.rest.ApiClient;
import com.keyfalcon.blockchain.rest.ApiInterface;
import com.keyfalcon.blockchain.utils.Pref;

/**
 * Created by Shylesh on 19-Jan-18.
 */

public class App extends Application{

    private static Context appContext;
    public static Pref mPref;
    private static DbHelper mDbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        appContext = this;
        mPref = new Pref(appContext);
    }

    public static Pref getPref() {
        if (mPref == null) {
            mPref = new Pref(appContext);
        }
        return mPref;
    }

    public static Context getAppContext()
    {
        return appContext;
    }

    public static DbHelper getDatabaseHelper() {

        if (mDbHelper == null) {
            mDbHelper = new DbHelper(appContext);
        }

        return mDbHelper;
    }

    public static ApiInterface getApiService() {
        return ApiClient.getClient().create(ApiInterface.class);
    }
}
