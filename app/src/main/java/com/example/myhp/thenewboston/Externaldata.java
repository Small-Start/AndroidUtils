package com.example.myhp.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by my hp on 1/7/2016.
 */
public class Externaldata extends Activity implements AdapterView.OnItemSelectedListener,View.OnClickListener{
private TextView canread,canwrite;
    private String state;
    boolean canr,canw;
    Spinner spinner;
    String[] paths={"Music","Pictures","Download"};
    File path=null;
    File file=null;
    EditText et;
    Button confirm,save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.externaldata);
        canread=(TextView)findViewById(R.id.tvcanread);
        canwrite=(TextView)findViewById(R.id.tvcanwrite);
        et=(EditText)findViewById(R.id.editspinner);
        confirm=(Button)findViewById(R.id.bconfirmsaveas);
        save=(Button)findViewById(R.id.bsaveas);
        confirm.setOnClickListener(this);
        save.setOnClickListener(this);

        checkState();

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Externaldata.this, android.R.layout.simple_spinner_item,paths);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    private void checkState() {

        state= Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED))
        {
            canread.setText("true");
            canwrite.setText("true");
            canr=canw=true;
        }
        else if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
        {
            canwrite.setText("false");
            canread.setText("true");
            canw=false;
            canr=true;
        }
        else
        {
            canread.setText("false");
            canwrite.setText("false");
            canr=canw=false;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //int position=spinner.getSelectedItemPosition();
        switch(position){
            case 0:
                path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                break;
            case 1:
                path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                break;
            case 2:
                path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bsaveas:
                String f=et.getText().toString();
                file=new File(path,f);
                checkState();
                if(canw==canr==true){
                    path.mkdirs();
                    InputStream is=getResources().openRawResource(R.drawable.greenball);
                    OutputStream os= null;
                    try {
                        os = new FileOutputStream(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    byte[] data= new byte[0];
                    try {
                        data = new byte[is.available()];
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        is.read(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        os.write(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast t= Toast.makeText(Externaldata.this,"File has been saved!!",Toast.LENGTH_LONG);
                    t.show();
                }
                break;
            case R.id.bconfirmsaveas:
                save.setVisibility(View.VISIBLE);
                break;
        }
    }
}
