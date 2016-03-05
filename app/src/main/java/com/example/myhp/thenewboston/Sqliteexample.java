package com.example.myhp.thenewboston;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by my hp on 1/16/2016.
 */
public class Sqliteexample extends Activity implements View.OnClickListener{

    EditText name,hotness,rowid;
    Button update,bview,getinfo,editentry,deleteentry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteexample);
        name=(EditText)findViewById(R.id.editsqlname);
        hotness=(EditText)findViewById(R.id.editsqlhotness);
        update=(Button)findViewById(R.id.updatesql);
        bview=(Button)findViewById(R.id.sqlview);
        getinfo=(Button)findViewById(R.id.bgetinfo);
        editentry=(Button)findViewById(R.id.beditentry);
        rowid=(EditText)findViewById(R.id.editrowid);
        deleteentry=(Button)findViewById(R.id.bdeleteentry);
        getinfo.setOnClickListener(this);
        editentry.setOnClickListener(this);
        deleteentry.setOnClickListener(this);
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
        case R.id.bgetinfo:
        String s=rowid.getText().toString();
            long l=Long.parseLong(s);
            Hotornot hon=new Hotornot(this);
            try {
                hon.open();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String returnname=hon.getname(l);
            String returnhotness=hon.gethotness(l);
            name.setText(returnname);
            hotness.setText(returnhotness);
            break;
        case R.id.beditentry:
            String se=rowid.getText().toString();
            long le=Long.parseLong(se);
            String snamee = name.getText().toString();
            String shotnesse = hotness.getText().toString();
            Hotornot hu=new Hotornot(this);
            try {
                hu.open();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            hu.updateEntry(le,snamee,shotnesse);
            hu.close();
            break;
        case R.id.bdeleteentry:
            String sd=rowid.getText().toString();
            long ld=Long.parseLong(sd);
            Hotornot ex1=new Hotornot(this);
            try {
                ex1.open();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ex1.deleteEntry(ld);
            ex1.close();

            break;
    }
    }
}

