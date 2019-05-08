package com.example.notificationmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "channelId")
                .setSmallIcon(R.drawable.ic_notification).setContentTitle("SUNNY!").setContentText("HELLO SUMMER!");

        Intent tapActionIntent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 23, tapActionIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pendingIntent);

        final View root = findViewById(R.id.activity_main__cl__root);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "background clicked");
                NotificationManager notifManager = (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
                notifManager.notify(new Random().nextInt(2),
                        builder.build());
            }
        });
    }
}
