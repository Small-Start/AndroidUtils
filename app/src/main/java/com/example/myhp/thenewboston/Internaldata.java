package com.example.myhp.thenewboston;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by my hp on 1/2/2016.
 */
public class Internaldata extends Activity implements View.OnClickListener {

    EditText shareddata;
    TextView dataresults;
    String filename="InternalString";
    FileOutputStream fos;


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
        try {
            fos=openFileOutput(filename,MODE_PRIVATE);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bsaveshared:
            String data=shareddata.getText().toString();
                try {
                    fos=openFileOutput(filename,MODE_PRIVATE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    fos.write(data.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.bloadshared:
               new Loadsomestuff().execute(filename);




        }

    }

    public class Loadsomestuff extends AsyncTask<String,Integer,String>{
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(Internaldata.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(100);
            dialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            dialog.incrementProgressBy(values[0]);
        }

        @Override
        protected String doInBackground(String... params) {

            String collected=null;
            FileInputStream fis=null;

            for(int i=0;i<20;i++){
                publishProgress(5);
                try {
                    Thread.sleep(88);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            dialog.dismiss();



            try {
                fis=openFileInput(filename);
                byte[] dataarray=new byte[fis.available()];
                while (fis.read(dataarray)!=-1)
                {
                    collected=new String(dataarray);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                        return collected;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String b="couldnt load your data";
            if(s!=null)
            dataresults.setText(s);
            else
                dataresults.setText(b);
        }
    }
}
