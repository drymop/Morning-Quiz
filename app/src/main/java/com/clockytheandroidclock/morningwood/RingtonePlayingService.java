package com.clockytheandroidclock.morningwood;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ryannamgung on 3/3/18.
 */

public class RingtonePlayingService extends Service {

    MediaPlayer media_song;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("in the service", "startcommand" + startId);

        media_song = MediaPlayer.create(this, R.raw.arianagrande);
        media_song.start();
        media_song.setLooping(true);
        return START_NOT_STICKY; // Somehow if service stops, this restarts
    }

    public void onDestroy() {
        media_song.stop();
        super.onDestroy();
    }
}
