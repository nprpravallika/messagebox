package com.example.dell.messageebox;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.SmsManager;

/**
 * Created by DELL on 31-10-2018.
 */


public class AlarmService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int onStartCommand(Intent i, int flags, int startId) {
        // TODO Auto-generated method stub
        String SPhone =i.getStringExtra("exPhone");
        String SSms = i.getStringExtra("exSmS");

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(SPhone, null, SSms, null, null);

        return START_STICKY;
    }

}

