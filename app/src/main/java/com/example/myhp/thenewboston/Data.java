package com.example.myhp.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by my hp on 10/7/2015.
 */
public class Data extends Activity implements View.OnClickListener{

    EditText et;
    Button bsa,bsafr;
    TextView seet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);
        initialize();
    }

    private void initialize() {
        et=(EditText) findViewById(R.id.etsend);
        bsa=(Button) findViewById(R.id.bsa);
        bsafr=(Button) findViewById(R.id.bsafr);
        seet=(TextView) findViewById(R.id.tvgot);
        bsa.setOnClickListener(this);
        bsafr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
switch(v.getId())
{
    case R.id.bsa:
    String pizza=et.getText().toString();
        Bundle basket=new Bundle();
        basket.putString("key",pizza);
        Intent a=new Intent(Data.this,Openedclass.class);
        a.putExtras(basket);
        break;
    case R.id.bsafr:
    Intent i=new Intent(Data.this,Openedclass.class);
        startActivityForResult(i,0);
        break;
}
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       try {
           if(resultCode==RESULT_OK) {
               Bundle backpack = data.getExtras();
               String s = backpack.getString("answer");
               seet.setText(s);
           }
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }
}
