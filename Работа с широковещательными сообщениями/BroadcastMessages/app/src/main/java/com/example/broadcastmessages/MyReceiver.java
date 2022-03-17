package com.example.broadcastmessages;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,
                "Обнаружено сообщение: " + intent.getStringExtra("ru.alexanderklimov.broadcast.Message"),
                Toast.LENGTH_LONG).show();
    }
}