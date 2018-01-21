package com.keyfalcon.blockchain.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.keyfalcon.blockchain.R;
import com.keyfalcon.blockchain.activities.Splash;

public class BlockFirebaseMessagingService extends FirebaseMessagingService {

    public BlockFirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        sendNotification(remoteMessage);
    }

    private void sendNotification(RemoteMessage remoteMessage) {
        RemoteMessage.Notification messageBody = remoteMessage.getNotification();

        String notificationContent = messageBody.getBody();

       /* Map<String, String> data = remoteMessage.getData();
        if (data.containsKey("message")) {
            data.get("message");
            data.get("senderPic");
            notificationContent = "Message from " + data.get("senderName");
        } else if (data.containsKey("videoName")) {
            data.get("videoName");
            data.get("videoPoster");
            data.get("videoUrl");
            notificationContent = "New review request from " + data.get("senderName");
        }*/

        Intent intent = new Intent(this, Splash.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);
//        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
//        bigPictureStyle.setBigContentTitle("SportzUtility");
//        bigPictureStyle.bigPicture(getBitmapFromURL("https://source.unsplash.com/collection/345761"));
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(messageBody.getTitle())
                .setContentText(notificationContent)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}
