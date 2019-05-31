package com.abc.mytaskapplication.PushNotification;

import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        }


    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
    }
}
