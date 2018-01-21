package com.keyfalcon.blockchain.services;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.gson.JsonObject;
import com.keyfalcon.blockchain.App;
import com.keyfalcon.blockchain.model.ResponseModel;
import com.keyfalcon.blockchain.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlockFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private final String TAG = "fcm token";

    public BlockFirebaseInstanceIDService() {
    }

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("fcmToken", refreshedToken);
        jsonObject.addProperty("id", App.getPref().getString(Constants.KEY_USER_ID));
        try {
            Call<ResponseModel> call = App.getApiService().updateFrmToken(jsonObject);

            call.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
