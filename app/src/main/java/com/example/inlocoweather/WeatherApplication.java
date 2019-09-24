package com.example.inlocoweather;

import android.app.Application;

import com.google.firebase.iid.FirebaseInstanceId;
import com.inlocomedia.android.engagement.InLocoEngagement;
import com.inlocomedia.android.engagement.InLocoEngagementOptions;
import com.inlocomedia.android.engagement.request.FirebasePushProvider;
import com.inlocomedia.android.engagement.request.PushProvider;

public class WeatherApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        InLocoEngagementOptions options = InLocoEngagementOptions.getInstance(this);

        options.setApplicationId(getBaseContext().getResources().getString(R.string.inloco_api_key));

        options.setLogEnabled(true);

        options.setRequiresUserPrivacyConsent(true);

        InLocoEngagement.init(this, options);


        String firebaseToken = FirebaseInstanceId.getInstance().getToken();
        if (firebaseToken != null && !firebaseToken.isEmpty()) {
            final PushProvider pushProvider = new FirebasePushProvider.Builder()
                    .setFirebaseToken(firebaseToken)
                    .build();
            InLocoEngagement.setPushProvider(this, pushProvider);
        }

    }

}
