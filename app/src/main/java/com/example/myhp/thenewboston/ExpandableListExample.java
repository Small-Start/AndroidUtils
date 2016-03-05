package com.example.myhp.thenewboston;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.security.acl.Group;
import java.util.ArrayList;

/**
 * Created by my hp on 2/24/2016.
 */
public class ExpandableListExample extends AppCompatActivity implements View.OnClickListener{

    private ExpandableListAdapter ExpAdapter;
    private ArrayList<Groups> ExpListItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_expandablelistview);

        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandableListAdapter(ExpandableListExample.this, ExpListItems,this);
        ExpandList.setAdapter(ExpAdapter);



    }

    public ArrayList<Groups> SetStandardGroups() {

        String group_names[] = { "GROUP A", "GROUP B", "GROUP C", "GROUP D",
                "GROUP E", "GROUP F", "GROUP G", "GROUP H" };

        String country_names[] = { "Brazil", "Mexico", "Croatia", "Cameroon",
                "Netherlands", "chile", "Spain", "Australia", "Colombia",
                "Greece", "Ivory Coast", "Japan", "Costa Rica", "Uruguay",
                "Italy", "England", "France", "Switzerland", "Ecuador",
                "Honduras", "Agrentina", "Nigeria", "Bosnia and Herzegovina",
                "Iran", "Germany", "United States", "Portugal", "Ghana",
                "Belgium", "Algeria", "Russia", "Korea Republic" };



        ArrayList<Groups> list = new ArrayList<Groups>();

        ArrayList<Child> ch_list;

        int size = 4;
        int j = 0;

        for (String group_name : group_names) {
            Groups gru = new Groups();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            for (; j < size; j++) {
                Child ch = new Child();
                ch.setName(country_names[j]);

                ch_list.add(ch);
            }
            gru.setItems(ch_list);
            list.add(gru);

            size = size + 4;
        }

        return list;
    }


    public void onTextClick(View v) {
        Toast t=Toast.makeText(ExpandableListExample.this,"hello",Toast.LENGTH_LONG);
        t.show();
    }

    @Override
    public void onClick(View v) {

    }
    public void expand(int g)
    {
        if(!ExpandList.isGroupExpanded(g))
        ExpandList.expandGroup(g);
        else
            ExpandList.collapseGroup(g);
    }
}
