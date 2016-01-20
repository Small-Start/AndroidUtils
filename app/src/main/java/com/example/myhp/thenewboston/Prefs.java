package com.example.myhp.thenewboston;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by my hp on 10/26/2015.
 */
public class Prefs extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.prefr);
    }
}
