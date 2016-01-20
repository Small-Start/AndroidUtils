package com.example.myhp.thenewboston;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by my hp on 1/16/2016.
 */
public class Sqliteexample extends Activity implements View.OnClickListener{

    EditText name,hotness;
    Button update,bview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteexample);
        name=(EditText)findViewById(R.id.editsqlname);
        hotness=(EditText)findViewById(R.id.editsqlhotness);
        update=(Button)findViewById(R.id.updatesql);
        bview=(Button)findViewById(R.id.sqlview);
        update.setOnClickListener(this);
        bview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.updatesql:
           boolean diditwork=true;
            try {
                String sname = name.getText().toString();
                String shotness = hotness.getText().toString();
                Hotornot entry = new Hotornot(Sqliteexample.this);
                entry.open();
                entry.createentry(sname, shotness);
                entry.close();
            }
            catch(Exception e){
                diditwork=false;
            }
            if(diditwork){
                Dialog d=new Dialog(this);
                d.setTitle("Heck Yea!");
                TextView tv=new TextView(this);
                tv.setText("Success");
                d.setContentView(tv);
                d.show();
            }









            break;
        case R.id.sqlview:


            Class c= null;
            try {
                c = Class.forName("com.example.myhp.thenewboston.Sqlview");
                Intent i=new Intent(Sqliteexample.this,c);
                startActivity(i);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            break;
    }
    }
}

