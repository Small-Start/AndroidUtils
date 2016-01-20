package com.example.myhp.thenewboston;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

/**
 * Created by my hp on 11/24/2015.
 */
public class Soundstuss extends Activity implements View.OnClickListener,View.OnLongClickListener {
    SoundPool sp;
    int explosion=0;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v=new View(this);
        setContentView(v);
        v.setOnClickListener(this);
       v.setOnLongClickListener(this);
       sp=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        explosion=sp.load(this,R.raw.explosion,1);
        mp=MediaPlayer.create(this, R.raw.bapuzimindar);

    }

    @Override
   public void onClick(View v) {
      if(explosion!=0)
            sp.play(explosion,1,1,0,0,1);
    }

    @Override
    public boolean onLongClick(View v) {
        mp.start();
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.release();

    }
}
