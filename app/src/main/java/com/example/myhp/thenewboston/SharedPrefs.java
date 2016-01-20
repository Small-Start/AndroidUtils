package com.example.myhp.thenewboston;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by my hp on 1/2/2016.
 */
public class SharedPrefs extends Activity implements View.OnClickListener {

    EditText shareddata;
    TextView dataresults;
    String filename="My Shared String";
    SharedPreferences somedata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared);
        Button save=(Button)findViewById(R.id.bsaveshared);
        Button load=(Button)findViewById(R.id.bloadshared);
        shareddata=(EditText)findViewById(R.id.sharededit);
        dataresults=(TextView)findViewById(R.id.tvshared);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
        somedata=getSharedPreferences(filename,0);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bsaveshared:
                String stringdata=shareddata.getText().toString();
                SharedPreferences.Editor editor=somedata.edit();
                editor.putString("sharedstring",stringdata);
                editor.commit();
                break;

            case R.id.bloadshared:
               // somedata=getSharedPreferences(filename,0);
                String datareturned=somedata.getString("sharedstring","couldn't load data");
                dataresults.setText(datareturned);
        }

    }
}
