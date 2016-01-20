package com.example.myhp.thenewboston;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

/**
 * Created by my hp on 1/6/2016.
 */
public class Notify extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify);
        Button b=(Button)findViewById(R.id.bnotify);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.greenball);
        builder.setContentTitle("hello this is a notification");
        builder.setContentText("happy");
        NotificationManager n=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        n.notify(5,builder.build());
    }
}
