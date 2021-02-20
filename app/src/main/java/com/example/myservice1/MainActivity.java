package com.example.myservice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myservice1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    static final String MESSAGE_KEY ="key" ;
    ActivityMainBinding mMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mMainBinding.getRoot());

        mMainBinding.read.setOnClickListener(view -> {
            readData();
        });
        mMainBinding.clerar.setOnClickListener(view -> {
            mMainBinding.sowMessage.setText("clear is run");
            stopSerices();
        });
    }

    private void stopSerices() {
        Intent intent=new Intent(MainActivity.this,MyService.class);
        stopService(intent);

    }

    private void readData() {

        for (String song:SongClass.song)
        {
            Intent intent=new Intent(MainActivity.this,MyService.class);
            intent.putExtra(MESSAGE_KEY,song);
            startService(intent);
        }
    }

}