package com.keyfalcon.blockchain.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.keyfalcon.blockchain.R;

public class OtpAct extends AppCompatActivity implements View.OnClickListener {

    private Context mContext = OtpAct.this;

    private TextView mTvResend;
    private EditText mEtOtp;
    private Button mBSubmit;

    private String mOtp = "";

    private BroadcastReceiver mBReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("otp")) {
                String message = intent.getStringExtra("message");
                if (message.equalsIgnoreCase(mOtp)) {
                    Intent i = new Intent(mContext, Dashboard.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(mContext, "Otp doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUi();
        initListener();

    }

    private void initUi() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_otp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.GONE);

        mEtOtp = findViewById(R.id.etOtp);
        mBSubmit = findViewById(R.id.bSubmit);
        mTvResend= findViewById(R.id.tvResendOtp);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBReceiver);
    }

    private void initListener() {

        findViewById(R.id.bSubmit).setOnClickListener(this);
        findViewById(R.id.tvResendOtp).setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        LocalBroadcastManager.getInstance(this).
                registerReceiver(mBReceiver, new IntentFilter("otp"));
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSubmit:
                if (validate()) {
                    startActivity(new Intent(mContext, Dashboard.class));
                    finish();
                }
                break;
            case R.id.tvResendOtp:
                break;
        }
    }

    private boolean validate() {
        if (mEtOtp.getText().toString().isEmpty() || mEtOtp.getText().toString().length() < 6){
            Toast.makeText(mContext, "OTP must be of 6 digits", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
