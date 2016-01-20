package com.example.myhp.thenewboston;
import android.app.Activity;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.myhp.thenewboston.R;

/**
 * Created by my hp on 10/7/2015.
 */
public class Openedclass extends Activity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {
    TextView ques,ans;
    Button re;
    String gotbread;
    RadioGroup rg;
    String ans1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
       // Bundle gotbasket=getIntent().getExtras();
       // gotbread=gotbasket.getString("key");
       // ques.setText(gotbread);
        initialize();
        SharedPreferences getdata= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String et=getdata.getString("name","kanishk");
        String values=getdata.getString("list","4");
        if(values.contentEquals("1"))
        {
            ques.setText(et);
        }


    }

    private void initialize() {
    ques=(TextView)findViewById(R.id.tvis);
        ans=(TextView)findViewById(R.id.tvsi);
        re=(Button)findViewById(R.id.breturn);
        re.setOnClickListener(this);
        rg=(RadioGroup)findViewById(R.id.rgsi);
        rg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
switch(checkedId) {
    case R.id.crazy:
    ans1="you are crazy";
        break;
    case R.id.idiot:
    ans1="you are idiot";
        break;
    case R.id.both:
    ans1="you are both";
        break;
}
        ans.setText(ans1);
    }

    @Override
    public void onClick(View v) {
        Intent person=new Intent();
        Bundle back=new Bundle();
        back.putString("answer",ans1);
        person.putExtras(back);
        setResult(RESULT_OK,person);
        finish();
    }
}
