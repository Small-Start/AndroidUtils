package com.example.myhp.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by my hp on 1/15/2016.
 */
public class Voice extends Activity implements View.OnClickListener
{
    ListView lv;
    static final int check=4444;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice);
        lv =(ListView)findViewById(R.id.voicelist);
        Button n=(Button)findViewById(R.id.bVoice);
        n.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak up!!");
        i.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
        startActivityForResult(i, check);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==check&&resultCode==RESULT_OK){

            ArrayList<String> results=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,results));
        }
    }
}
