package com.keyfalcon.blockchain.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.gson.JsonObject;
import com.keyfalcon.blockchain.App;
import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.model.ResponseModel;
import com.keyfalcon.blockchain.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "Login";
    private Context mContext = Login.this;
    private EditText mEtUsername;

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
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.GONE);

        mEtUsername = findViewById(R.id.etUsername);
    }

    private void initListener() {
        findViewById(R.id.bLogin).setOnClickListener(this);
        findViewById(R.id.tvRegister).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogin:
                if (validate()) {
//                    requestOtp();
                    Intent intent = new Intent(mContext, OtpAct.class);
                    startActivity(intent);
                }
                break;
            case R.id.tvRegister:
                startActivity(new Intent(mContext, Register.class));
                break;
        }
    }

    private void requestOtp() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("contect", mEtUsername.getText().toString());
        Call<ResponseModel> call = App.getApiService().getOtp(jsonObject);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Log.d(TAG, "onResponse: ");
                if (response.body().getCode() == 200) {
                    Log.d(TAG, "onSuccess: ");
                    Intent intent = new Intent(mContext, OtpAct.class);
                    startActivity(intent);
                } else if (response.body().getCode() == 201) {
                    Utils.showToast(mContext, "Please register your mobile");
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
                t.printStackTrace();
            }
        });
    }

    private boolean validate() {
        if (mEtUsername.getText().toString().isEmpty() || mEtUsername.getText().toString().length() < 10) {
            Utils.showToast(mContext, "Phone number must be of 10 digits");
            return false;
        }
        return true;
    }
}
