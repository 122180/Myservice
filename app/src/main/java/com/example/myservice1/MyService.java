package com.example.myservice1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";
    private Mythread mythread;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(TAG, "onBind: ");

       return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mythread=new Mythread();
       Thread thread= new Thread(mythread);
               thread.start();
        while (thread==null)
        {

        }

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String song=intent.getStringExtra(MainActivity.MESSAGE_KEY);
        Message msg=Message.obtain();
         msg.obj=song;
         mythread.mMyOwnHandler.sendMessage(msg);

        /*<!--Todo first approach to start service but its not good programming practice
               because all for each song one thread are exected
         */



      /*  Thread thread=new Thread(new Runnable() {
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
        thread.start();*/

        Log.d(TAG, "onStartCommand: ");
        return Service.START_REDELIVER_INTENT;//depend on all behivoior of system
    }




    /*public void downLoadSong(String message) {
        Log.d(TAG, "downLoadSong: Start :"+message);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "downLoadSong: complete :"+message);
    }
    */
}