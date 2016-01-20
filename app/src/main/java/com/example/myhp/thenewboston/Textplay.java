package com.example.myhp.thenewboston;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

import static android.view.Gravity.START;

/**
 * Created by my hp on 10/4/2015.
 */
public class Textplay extends Activity implements View.OnClickListener{
    TextView v1;
    ToggleButton t1;
    EditText e1;
    Button b1;
    @Override
    protected void onCreate(Bundle donut)
    {
        super.onCreate(donut);
        setContentView(R.layout.usingedittext);
        baconandeggs();

        t1.setOnClickListener(this);
        b1.setOnClickListener(this);

    }

    private void baconandeggs() {
        b1=(Button) findViewById(R.id.textbutton1);
        e1=(EditText) findViewById(R.id.textedit1);
        t1=(ToggleButton) findViewById(R.id.texttoggleButton1);
        v1=(TextView) findViewById(R.id.newtextview1);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.texttoggleButton1:
                if(t1.isChecked())
                {
                    e1.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_NUMBER_VARIATION_PASSWORD);

                }
                else
                {
                    e1.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;
            case R.id.textbutton1:

                String chw=e1.getText().toString();
                if(chw.contentEquals("left"))
                {
                    v1.setGravity(Gravity.START);
                }
                else if(chw.contentEquals("right"))
                {
                    v1.setGravity(Gravity.END);
                }
                else if(chw.contentEquals("center"))
                {
                    v1.setGravity(Gravity.CENTER);
                }
                else if(chw.contentEquals("blue"))
                {
                    v1.setTextColor(Color.BLUE);
                }
                else if(chw.contains("WTF")){
                    Random crazy=new Random();
                    v1.setText("WTF!!!!");
                    v1.setTextSize(crazy.nextInt(75));
                    v1.setTextColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(265),crazy.nextInt(265)));
                    switch(crazy.nextInt(3))
                    {
                        case 0:
                            v1.setGravity(Gravity.START);
                            break;
                        case 1:
                            v1.setGravity(Gravity.CENTER);
                            break;
                        case 2:
                            v1.setGravity(Gravity.END);
                    }
                }
                else
                {
                    v1.setText("invalid");
                }

                break;
        }
    }
}
