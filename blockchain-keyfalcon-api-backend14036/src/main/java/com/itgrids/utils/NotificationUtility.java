package com.itgrids.utils;

import java.io.IOException;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

public class NotificationUtility {

	private static String ANDROID_NOTIFICATION_URL = "https://fcm.googleapis.com/fcm/send";

	private static String ANDROID_NOTIFICATION_KEY = "AAAAY-EfO8M:APA91bEPCDdFHL1OtAboK6Q7KoKNVxRTyrNUA6Lmzyp00c_mKvr_xuFiV8qbUV2AAZpbeUpSLoFMLsdGUsfoep6_Fm3uKOC0efiiAW_gxYjRyt1NxaEcRyYrYCAXXVS0RYlXN21b-932";

	private void sendAndroidNotification(String deviceToken, String message) throws JSONException {
		// OrderSummary orderSummary = orderDao.get(orderId);

		OkHttpClient client = new OkHttpClient();
		com.squareup.okhttp.MediaType mediaType = com.squareup.okhttp.MediaType.parse("application/json");
		JSONObject obj = new JSONObject();
		JSONObject msgObject = new JSONObject();
		if (message.equalsIgnoreCase("clarify")) {
			msgObject.put("body", "Your request for seedlings need clarification ");
		} else {
			msgObject.put("body", "Your request for seedlings has been " + message);
		}

		msgObject.put("title", "Blockchain");
		// msgObject.put("orderId", orderId);
		// msgObject.put("Total Amount", orderSummary.getTotalOrderPrice());
		//
		obj.put("to", deviceToken);

		obj.put("notification", msgObject);

		RequestBody body = RequestBody.create(mediaType, obj.toString());
		Request request = new Request.Builder().url(ANDROID_NOTIFICATION_URL).post(body)
				.addHeader("content-type", "application/json")
				.addHeader("authorization", "key=" + ANDROID_NOTIFICATION_KEY).build();

		try {
			com.squareup.okhttp.Response response = client.newCall(request).execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendNotification(String token, String message) throws JSONException {
		// TODO Auto-generated method stub
		sendAndroidNotification(token, message);
	}

}
