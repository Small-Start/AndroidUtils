package com.example.myhp.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by my hp on 2/22/2016.
 */
public class Listexample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewexample);
        ListView lv=(ListView)findViewById(R.id.listView_example);
        ArrayList<String> arr=new ArrayList<>();
        arr.add("Happy");
        arr.add("Hello");

        ArrayAdapter items=new CustomListAdapter(Listexample.this , R.layout.custom_list ,arr);
        lv.setAdapter(items);

    }
}
