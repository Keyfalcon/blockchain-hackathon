package com.keyfalcon.blockchain.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.keyfalcon.blockchain.App;
import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.utils.Constants;

public class Splash extends AppCompatActivity {

    private Context mContext = Splash.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (App.getPref().getBoolean(Constants.KEY_LOGIN_STATUS)) {
//                    startActivity(new Intent(mContext, Dashboard.class));
//                    finish();
                } else {
                    startActivity(new Intent(mContext, Login.class));
                    finish();
                }
            }
        });
        thread.start();
    }
}
