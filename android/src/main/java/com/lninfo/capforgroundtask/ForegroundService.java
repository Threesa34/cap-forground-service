package com.lninfo.capforgroundtask;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class ForegroundService extends Service{

private static final String CHANNEL_ID = "ForegroundServiceChannel";
    private static final int NOTIFICATION_ID = 12345;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("inputExtra");

        createNotificationChannel();
        Notification notification = buildNotification(input);

        startForeground(NOTIFICATION_ID, notification);

        // Perform your long-running task here
        // Replace with your actual task logic
        startBackgroundTask();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }

    private Notification buildNotification(String input) {
        return new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Foreground Service")
                .setContentText(input)
                .setSmallIcon(R.mipmap.ic_launcher) // Replace with your app's icon
                .build();
    }

    private void startBackgroundTask() {
        // Replace with your background task logic
        // This is where you would perform long-running operations
        // Ensure to manage threads and handle tasks efficiently
        // For demonstration, we'll just sleep for a few seconds
        new Thread(() -> {
            try {
                Thread.sleep(10000); // Simulate long-running task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stopSelf(); // Stop the service when task is complete
        }).start();
    }
    
}
