package com.clockytheandroidclock.morningwood;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ryannamgung on 3/3/18.
 */

public class AlarmReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("In the receiver!", "Hi");

        Intent service_intent = new Intent(context, RingtonePlayingService.class);
        Log.e("Service intent created!", "Hi");


        //start the ringtone service
        context.startService(service_intent);
        Log.e("Service has been called", "Hi");

    }
}
