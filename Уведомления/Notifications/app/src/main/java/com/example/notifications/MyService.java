package com.example.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    final String CHANNEL_ID = "CHANNEL_ID";
    NotificationManager notificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        PendingIntent firstPendingIntentActivity = PendingIntent.getActivity(this,
                0,
                new Intent(this, FirstActivity.class),
                0);

        PendingIntent secondPendingIntentActivity = PendingIntent.getActivity(this,
                0,
                new Intent(this, SecondActivity.class),
                0);

        Notification notification =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setWhen(System.currentTimeMillis())
                        .setContentTitle("Уведомление из сервиса")
                        .setContentText("Это уведомление было создано в сервисе")
                        .setContentIntent(firstPendingIntentActivity)
                        .addAction(R.mipmap.ic_launcher, "First activity", firstPendingIntentActivity)
                        .addAction(R.mipmap.ic_launcher, "Second activity", secondPendingIntentActivity)
                        .build();

        startForeground(1, notification);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }
}