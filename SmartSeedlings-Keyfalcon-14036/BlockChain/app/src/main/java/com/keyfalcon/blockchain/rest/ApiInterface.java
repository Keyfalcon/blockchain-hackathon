package com.keyfalcon.blockchain.rest;

import com.google.gson.JsonObject;
import com.keyfalcon.blockchain.model.FarmerModel;
import com.keyfalcon.blockchain.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Shylesh on 20-Jan-18.
 */

public interface ApiInterface {

    @POST("farmer/registerFarmer")
    Call<ResponseModel> registerFarmer(@Body FarmerModel farmer);

    @POST("user/getOtp")
    Call<ResponseModel> getOtp(JsonObject contact);

    @POST("user/updateFcmToken")
    Call<ResponseModel> updateFrmToken(JsonObject o);
}
