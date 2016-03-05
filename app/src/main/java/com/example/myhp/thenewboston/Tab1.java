package com.example.myhp.thenewboston;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Tab1 extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.tab_1,container,false);
v.findViewById(R.id.button10).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
Toast t= Toast.makeText(getContext(),"the newboston",Toast.LENGTH_LONG);
        t.show();
    }
}