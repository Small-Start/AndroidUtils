package com.example.myhp.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

/**
 * Created by my hp on 12/28/2015.
 */
public class Flipper extends Activity implements View.OnClickListener{
    ViewFlipper flippy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper);
        flippy=(ViewFlipper)findViewById(R.id.viewFlipper);
        flippy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        flippy.showNext();
    }
}
