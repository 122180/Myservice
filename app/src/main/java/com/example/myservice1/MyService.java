package com.example.myservice1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(TAG, "onBind: ");
       return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String song=intent.getStringExtra(MainActivity.MESSAGE_KEY);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                downLoadSong(song);
            }
        });
        thread.start();

        Log.d(TAG, "onStartCommand: ");
        return Service.START_REDELIVER_INTENT;//depend on all behivoior of system
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        stopSelf();
    }

    public void downLoadSong(String message) {
        Log.d(TAG, "downLoadSong: Start :"+message);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "downLoadSong: complete :"+message);
    }
    
}