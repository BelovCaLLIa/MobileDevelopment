package ru.mirea.belov.mireaproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class PlayerService extends Service {

    static final String TAG = "PlayerService";
    private MediaPlayer mediaPlayer;

    public PlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate(){
        mediaPlayer=MediaPlayer.create(this, R.raw.ernesto_cortazar_dancing_waves);
        mediaPlayer.setLooping(true);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mediaPlayer.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }

    public void onClickPlayMusic(View view) {
        Log.i(TAG, "onClickPlayMusic");
        //startService(
                //new Intent(MainActivity.this, PlayerService.class));
    }

    public void onClickStopMusic(View view) {
        //stopService(
                //new Intent(MainActivity.this, PlayerService.class));
    }
}