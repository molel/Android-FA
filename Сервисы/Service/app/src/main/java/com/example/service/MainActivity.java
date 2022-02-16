package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final String TAG = "Service";
    boolean bound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.bind).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MyService.class);
        switch (view.getId()) {
            case R.id.start:
                startService(intent);
                stopService(intent);
                break;
            case R.id.bind:
                ServiceConnection serviceConnection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        Log.d(TAG, "onServiceConnected");
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName componentName) {
                        Log.d(TAG, "onServiceDisconnected");
                    }
                };
                if (!bound) {
                    bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                    bound = true;
                } else {
                    unbindService(serviceConnection);
                    bound = false;
                }
                break;
            default:
                break;
        }
    }
}