package com.example.anley.hw4_2;


import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;

public class BR_Notification extends BroadcastReceiver {
    static int id = 70000;

    @Override
    public void onReceive(Context context, Intent intent) {

        String msg = intent.getStringExtra("Name");

        Intent newintent = new Intent();
        intent.putExtra("Name", msg);
        newintent.setClass(context, ActivityNotification.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, newintent, FLAG_UPDATE_CURRENT);

        Notification notify = newNotification(context, pendingIntent, "Hello", msg);

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(id++, notify);
    }

    private Notification newNotification(
            Context context, PendingIntent pi,
            String title, String msg) {

        Notification.Builder builder =
                new Notification.Builder(context);
        builder.setContentTitle(title);
        builder.setContentText(msg);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pi);
        builder.setTicker(msg);
        builder.setWhen(System.currentTimeMillis());
        Notification notify = builder.build();
        return notify;
    }
}

