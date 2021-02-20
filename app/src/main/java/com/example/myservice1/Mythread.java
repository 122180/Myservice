package com.example.myservice1;

import android.os.Looper;

public class Mythread implements Runnable{
public MyOwnHandler mMyOwnHandler;
    @Override
    public void run() {
        Looper.prepare();
        mMyOwnHandler=new MyOwnHandler();
        Looper.loop();

    }
}
