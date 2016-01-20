package com.example.myhp.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by my hp on 10/4/2015.
 */
public class Newstart extends Activity {

  MediaPlayer song;
   @Override
    protected void onCreate(Bundle donut)
   {
       super.onCreate(donut);
       setContentView(R.layout.newbackground);
       song= MediaPlayer.create(Newstart.this,R.raw.bapuzimindar);

       SharedPreferences getPrefs= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
       boolean imsu=getPrefs.getBoolean("checkbox",true);
       if(imsu)
       song.start();
       Thread timer=new Thread(){
         public void run()
         {
             try{
sleep(2000);
             }
             catch(InterruptedException e)
             {
e.printStackTrace();
             }
             finally{
                 Intent in=new Intent("com.example.myhp.thenewboston.MENU");
                 startActivity(in);
             }
         }
       };
timer.start();
   }
    @Override
    protected void onPause()
    {
        super.onPause();
        song.release();
        finish();
    }
}
