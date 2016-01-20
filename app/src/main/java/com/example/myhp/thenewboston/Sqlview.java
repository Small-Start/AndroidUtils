package com.example.myhp.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by my hp on 1/19/2016.
 */
public class Sqlview extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlview);
        TextView tv=(TextView)findViewById(R.id.binfosql);
        Hotornot info= new Hotornot(this);
        try {
            info.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String data=info.getData();
        info.close();
        tv.setText(data);
    }
}
