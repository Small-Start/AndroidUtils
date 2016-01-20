package com.example.myhp.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by my hp on 12/22/2015.
 */
public class Tabs extends Activity implements View.OnClickListener {

    TabHost th;
    TextView tv;
    long start=0,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabeg);
        th=(TabHost)findViewById(R.id.tabHost);
        Button newtab=(Button)findViewById(R.id.addtab);
        Button start=(Button)findViewById(R.id.button7);
        Button stop=(Button)findViewById(R.id.button8);
        tv=(TextView)findViewById(R.id.tvstop);
        newtab.setOnClickListener(this);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        th.setup();
        TabHost.TabSpec specs=th.newTabSpec("tag1");
        specs.setContent(R.id.linearLayout);
        specs.setIndicator("Stopwatch");
        th.addTab(specs);
        specs=th.newTabSpec("tag2");
        specs.setContent(R.id.linearLayout2);
        specs.setIndicator("tab2");
        th.addTab(specs);
        specs=th.newTabSpec("tag3");
        specs.setContent(R.id.linearLayout3);
        specs.setIndicator("tab3");
        th.addTab(specs);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.addtab:
                TabHost.TabSpec ourspecs=th.newTabSpec("tag1");
                ourspecs.setContent(new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        TextView text = new TextView(Tabs.this);
                        text.setText("you've created a new tab");
                        return text;
                    }
                });
                ourspecs.setIndicator("new tab");
                th.addTab(ourspecs);
                break;
            case R.id.button7:
                start=System.currentTimeMillis();
                tv.setText(Long.toString(start));
                break;
            case R.id.button8:
                stop=System.currentTimeMillis();
                if(start!=0){
                    long result=stop-start;
                    int millis=(int)result;
                    int seconds=millis/1000;
                    int minutes=seconds/60;
                    millis=millis%100;
                    seconds=seconds%60;

                    tv.setText(String.format("%d:%02d:%02d",minutes,seconds,millis));
                }
                break;

        }
    }
}
