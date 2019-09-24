package com.example.inlocoweather.Firebase;

import android.util.Log;

import com.example.inlocoweather.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.inlocomedia.android.engagement.InLocoEngagement;
import com.inlocomedia.android.engagement.PushMessage;
import com.inlocomedia.android.engagement.request.FirebasePushProvider;
import com.inlocomedia.android.engagement.request.PushProvider;

import java.util.Map;

public class FirebaseMService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.i("FirebaseMService", "onMessageReceived: ->"+remoteMessage.getData().toString());
        presentMensage(remoteMessage.getData());
    }

    @Override
    public void onNewToken(String token) {
        Log.i("FirebaseMService", "onNewToken: "+token);

        if(token != null & !token.isEmpty()){
            final PushProvider pushProvider = new FirebasePushProvider.Builder()
                    .setFirebaseToken(token)
                    .build();

            InLocoEngagement.setPushProvider(this, pushProvider);
        }

    }

    public void presentMensage(Map<String, String> data){
        if(data != null){
            final PushMessage pushContent = InLocoEngagement.decodeReceivedMessage(this, data);

            if(pushContent != null){
                InLocoEngagement.presentNotification(
                        this, pushContent, R.drawable.ic_notification,
                        "channel1"
                );
            }else{
                Log.i("FirebaseMService", "presentMensage: REGULAR MENSAGE");
            }


        }
    }

}
