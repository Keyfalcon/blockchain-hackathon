package com.keyfalcon.blockchain.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.keyfalcon.blockchain.App;
import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.model.FarmerModel;
import com.keyfalcon.blockchain.model.LandModel;
import com.keyfalcon.blockchain.model.ResponseModel;
import com.keyfalcon.blockchain.utils.Constants;
import com.keyfalcon.blockchain.utils.Utils;

import java.sql.SQLException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private final int REQUEST_ADD_LANDS = 0x6001;
    private final String TAG = "Register";
    private Context mContext = Register.this;
    private EditText mEtName, mEtPhNo, mEtAdharNo, mEtBankAccount, mEtBankName, mEtIfsc;
    private Button mBContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUi();
        initListener();
    }

    private void initUi() {
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mEtName = findViewById(R.id.etName);
        mEtPhNo = findViewById(R.id.etPhNo);
        mEtAdharNo = findViewById(R.id.etAdharNo);
        mEtBankAccount = findViewById(R.id.etBankAccount);
        mEtBankName = findViewById(R.id.etBankName);
        mBContinue = findViewById(R.id.bContinue);
        mEtIfsc = findViewById(R.id.etIfsc);
        if (getIntent().hasExtra(Constants.KEY_IS_EDIT) && getIntent().getBooleanExtra(Constants.KEY_IS_EDIT, false))
            disableViews();
    }

    private void disableViews() {
        mEtName.setEnabled(false);
        mEtName.setFocusable(false);
        mEtPhNo.setEnabled(false);
        mEtPhNo.setFocusable(false);
        mEtAdharNo.setEnabled(false);
        mEtAdharNo.setFocusable(false);
        mBContinue.setText("Update");
    }

    private void initListener() {
        mBContinue.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bContinue:
                if (validate()) {
                    Intent intent = new Intent(mContext, AddLands.class);
                    startActivityForResult(intent, REQUEST_ADD_LANDS);
                }
                break;
        }
    }

    private boolean validate() {
        if (mEtName.getText().toString().isEmpty()) {
            Utils.showToast(mContext, "Please enter your name");
            return false;
        }
        if (mEtPhNo.getText().toString().isEmpty()) {
            Utils.showToast(mContext, "Please enter your phone number");
            return false;
        }
        if (mEtAdharNo.getText().toString().isEmpty()) {
            Utils.showToast(mContext, "Please enter your aadhar number");
            return false;
        }
        if (mEtBankAccount.getText().toString().isEmpty()) {
            Utils.showToast(mContext, "Please enter your bank account number");
            return false;
        }
        if (mEtBankName.getText().toString().isEmpty()) {
            Utils.showToast(mContext, "Please enter your bank name");
            return false;
        }
        if (mEtIfsc.getText().toString().isEmpty()) {
            Utils.showToast(mContext, "Please enter IFSC code");
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ADD_LANDS) {
            if (resultCode == RESULT_OK) {

               /* try {
                    FarmerModel farmer = new FarmerModel();
                    farmer.setName(mEtName.getText().toString());
                    farmer.setPhoneNumber(mEtPhNo.getText().toString());
                    farmer.setAadharNumber(Integer.parseInt(mEtAdharNo.getText().toString()));
                    farmer.setAccNumber(Integer.parseInt(mEtBankAccount.getText().toString()));
                    farmer.setBankName(mEtBankName.getText().toString());
                    farmer.setIfscCode(mEtIfsc.getText().toString());
                    farmer.setFcmToken(FirebaseInstanceId.getInstance().getToken());
                    farmer.setLocationDetails(App.getDatabaseHelper().getDao(LandModel.class).queryForAll());

                    registerFarmer(farmer);
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
                startActivity(new Intent(mContext, Dashboard.class));
            } else if (resultCode == RESULT_FIRST_USER) {
                Intent intent = new Intent(mContext, AddLands.class);
                startActivityForResult(intent, REQUEST_ADD_LANDS);
            }
        }
    }

    private void registerFarmer(final FarmerModel farmer) {
        Call<ResponseModel> call = App.getApiService().registerFarmer(farmer);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Log.d(TAG, "onResponse: " + call.request().body());
                if (response.body() != null && response.body().getCode() == 200) {
                    Log.d(TAG, "onSuccess: ");
                    for (LandModel model : farmer.getLocationDetails()) {
                        try {
                            App.getDatabaseHelper().getDao(LandModel.class).delete(model);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + call.request().body());
                Utils.showToast(mContext, getString(R.string.try_again));
            }
        });
    }
}
