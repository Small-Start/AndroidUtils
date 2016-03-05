package com.example.myhp.thenewboston;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;


/**
 * Created by my hp on 2/29/2016.
 */
public class Trysearchview extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchManager searchManager;
    ListView lv;
    boolean z=true;
    SimpleCursorAdapter st;
    private static final String[] SUGGESTIONS = {
            "Bauru", "Sao Paulo", "Rio de Janeiro",
            "Bahia", "Mato Grosso", "Minas Gerais",
            "Tocantins", "Rio Grande do Sul"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.try_searchview);
        Toolbar t=(Toolbar)findViewById(R.id.toolbar_searchview);
        setSupportActionBar(t);
        lv=(ListView)findViewById(R.id.listView);
       final String[] from = new String[] {"cityName"};
        final int[] to = new int[] {android.R.id.text1};
        st = new SimpleCursorAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                null,
                from,
                to,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

lv.setAdapter(st);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,  menu);
        // Get the SearchView and set the searchable configuration
         searchManager= (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true); // Do not iconify the widget; expand it by default
      //  searchView.setSubmitButtonEnabled(true);
       // searchView.setSuggestionsAdapter(st);
        searchView.setOnQueryTextListener(this);

        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        populate(newText);
        return false;
    }

    private void populate(String newText) {
        if(z!=true) {
            final MatrixCursor c = new MatrixCursor(new String[]{BaseColumns._ID, "cityName"});
            for (int i = 0; i < SUGGESTIONS.length; i++) {
                if (SUGGESTIONS[i].toLowerCase().startsWith(newText.toLowerCase()))
                    c.addRow(new Object[]{i, SUGGESTIONS[i]});
            }
            st.changeCursor(c);
        }
        else{
            z=false;
        }
    }
}
