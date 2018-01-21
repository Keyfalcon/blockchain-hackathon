package com.keyfalcon.blockchain.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.SmsMessage;

/**
 * Created by Shylesh on 21-Jan-18.
 */

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String SMS_EXTRA_NAME = "pdus";
        Bundle extras = intent.getExtras();

        if (extras != null) {
            Object[] smsExtra = (Object[]) extras.get(SMS_EXTRA_NAME);

            for (int i = 0; i < smsExtra.length; ++i) {
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) smsExtra[i]);

                String body = sms.getMessageBody().toString();
                String address = sms.getOriginatingAddress();

                if (address.contains("ADDRESS")) {

                    String[] otp = body.trim().split("\\s");

                    Intent smsIntent = new Intent("otp");
                    smsIntent.putExtra("message",otp[1]);
                    LocalBroadcastManager.getInstance(context).sendBroadcast(smsIntent);
                }
                break;
            }
        }
    }
}
