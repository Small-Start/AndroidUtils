package com.example.myhp.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

/**
 * Created by my hp on 1/16/2016.
 */
public class TextVoice extends Activity implements View.OnClickListener {

    EditText et;
    TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.texttospeech);
        et=(EditText)findViewById(R.id.ttsedit);
        Button b =(Button)findViewById(R.id.ttsbutton);
        b.setOnClickListener(this);
        tts=new TextToSpeech(TextVoice.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.ERROR){
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        String listen=et.getText().toString();
        tts.speak(listen,TextToSpeech.QUEUE_FLUSH,null,"up");
    }
}
