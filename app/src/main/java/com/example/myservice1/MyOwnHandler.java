package com.example.myservice1;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class MyOwnHandler extends Handler {
    private static final String TAG = "MyOwnHandler";

    @Override
    public void handleMessage(@NonNull Message msg1) {
        String msg = msg1.obj.toString();
        downLoadSong(msg);
    }

    public void downLoadSong(String message) {
        Log.d(TAG, "downLoadSong: Start :" + message);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "downLoadSong: complete :" + message);
    }
}
