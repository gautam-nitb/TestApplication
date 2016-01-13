package com.gauti.testapp;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {

    NotificationManager manager;
    Notification myNotication;
    static final int uniqueID = 1394885;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

public void shownotification(View view){
    Intent intent = new Intent("com.gauti.testapp.MAIN");

    PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this, 1, intent, 0);

    Notification.Builder builder = new Notification.Builder(NotificationActivity.this);



    builder.setAutoCancel(false);
    builder.setTicker("this is ticker text");
    builder.setContentTitle("User Generated Notification");
    builder.setContentText("autogen notifications are created using service");
    builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
    builder.setSmallIcon(R.drawable.gj);
    builder.setContentIntent(pendingIntent);
    builder.setOngoing(false);
   // builder.setSubText();   //API level 16
    builder.build();

    myNotication = builder.getNotification();

    myNotication.defaults=Notification.DEFAULT_VIBRATE;
    manager.notify(11, myNotication);
}

}
