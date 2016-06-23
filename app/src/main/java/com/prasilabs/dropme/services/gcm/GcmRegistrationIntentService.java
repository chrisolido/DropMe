package com.prasilabs.dropme.services.gcm;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.prasilabs.constants.GcmConstants;
import com.prasilabs.dropme.backend.dropMeApi.model.ApiResponse;
import com.prasilabs.dropme.backend.dropMeApi.model.GcmRecordIO;
import com.prasilabs.dropme.core.CoreApp;
import com.prasilabs.dropme.customs.LocalPreference;
import com.prasilabs.dropme.debug.ConsoleLog;
import com.prasilabs.dropme.managers.UserManager;
import com.prasilabs.dropme.services.network.CloudConnect;

/**
 * Created by prasi on 8/6/16.
 */
public class GcmRegistrationIntentService extends IntentService
{
    private static final String TAG = GcmRegistrationIntentService.class.getSimpleName();

    public GcmRegistrationIntentService() {
        super(TAG);
    }

    public static void startIntentService(Context context)
    {
        Intent intent = new Intent(context, GcmRegistrationIntentService.class);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        ConsoleLog.i(TAG, "on handle intent called");
        InstanceID instanceID = InstanceID.getInstance(this);
        try
        {
            String token = instanceID.getToken("805210209614", GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

            ConsoleLog.i(TAG, "gcm token is " + token);

            String existingToken = LocalPreference.getLoginDataFromShared(this, GcmConstants.GCM_TOKEN_STR, null);
            long lastUpdateTime = LocalPreference.getLoginDataFromShared(this, GcmConstants.GCM_KEY_UPDATE_TIME_STR, 0L);

            boolean isExpired = false;
            if (System.currentTimeMillis() - lastUpdateTime > 86400000)
            {
                isExpired = true;
            }

            if (existingToken == null || !existingToken.equals(token) || isExpired) {
                GcmRecordIO gcmRecordIO = new GcmRecordIO();
                gcmRecordIO.setGcmId(token);
                gcmRecordIO.setDeviceId(CoreApp.getDeviceId());
                gcmRecordIO.setUserId(UserManager.getUserId(this));

                ApiResponse apiResponse = CloudConnect.callDropMeApi(false).addGcmId(gcmRecordIO).execute();

                if (apiResponse.getStatus())
                {
                    LocalPreference.saveLoginDataInShared(this, GcmConstants.GCM_TOKEN_STR, token);
                    LocalPreference.saveLoginDataInShared(this, GcmConstants.GCM_KEY_UPDATE_TIME_STR, System.currentTimeMillis());
                }
            }
            else
            {
                ConsoleLog.i(TAG, "token already exist");
            }

        } catch (Exception e)
        {
            ConsoleLog.e(e);
        }
    }
}
