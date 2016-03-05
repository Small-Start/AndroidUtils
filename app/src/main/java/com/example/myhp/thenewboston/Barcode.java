package com.example.myhp.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by my hp on 3/5/2016.
 */
public class Barcode extends AppCompatActivity implements View.OnClickListener{
TextView tv;
    String SERVER_API_KEY="AIzaSyDvrevrBUumIAYU77Syk-GTb0fCisSdyaU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcode);
        findViewById(R.id.button_barcode).setOnClickListener(this);
    tv=(TextView)findViewById(R.id.text_barcode);
        tv.setText("Start Scanning");
    }

    @Override
    public void onClick(View v) {
        new IntentIntegrator(this).initiateScan();
    }



        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent intent) {
            super.onActivityResult(requestCode, resultCode, intent);


                    if (resultCode == Activity.RESULT_OK) {
                        // Parsing bar code reader result
                        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
                        //Toast.makeText(this,"its working"+result.getContents(),Toast.LENGTH_LONG).show();
tv.setText("ISBN Number:"+result.getContents());
                    }


        }
}
