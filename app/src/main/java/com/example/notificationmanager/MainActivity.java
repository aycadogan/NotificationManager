package com.example.notificationmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "channelId")
                .setSmallIcon(R.drawable.ic_notification).setContentTitle("SUNNY!").setContentText("HELLO SUMMER!");
        //tek satıra indirgeme: builder.setSmallIcon(1).setContentTitle("").setContentText("");

        final View root = findViewById(R.id.activity_main__cl__root);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "background clicked");
                NotificationManager notifManager = (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
                notifManager.notify(1, builder.build());
            }
        });
    }
}
