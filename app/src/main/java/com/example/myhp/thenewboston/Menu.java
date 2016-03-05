package com.example.myhp.thenewboston;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by my hp on 10/4/2015.
 */
public class Menu extends ListActivity{
String [] classes={"startingpoint","Textplay","Email","Cameraview","Data","Gfx","Gfxsurface","Soundstuss","Tabs","Simplebrowser","Flipper","SharedPrefs","Internaldata","Notify","Externaldata","Voice","TextVoice","Sqliteexample","Accelerate","Navigationdrawer","Barcode","MainActivity","Listexample","Locationlast","MainActivityTabs","ExpandableListExample","Trysearchview"};

    @Override
    protected void onCreate(Bundle saved)
{
    super.onCreate(saved);
    setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));


}

        @Override
    protected void onListItemClick(ListView l,View v,int position,long id)
        {
            super.onListItemClick(l, v, position, id);
            String ch=classes[position];
            try {
                Class ours = Class.forName("com.example.myhp.thenewboston."+ch);
                Intent in1 = new Intent(Menu.this, ours);
                startActivity(in1);
            }catch(ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowup=getMenuInflater();
        blowup.inflate(R.menu.newmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId())
        {
            case R.id.abtus:
                try {
                    Class ours = Class.forName("com.example.myhp.thenewboston.Aboutus");
                    Intent i = new Intent(Menu.this, ours);
                    startActivity(i);
                }
                catch(ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
                break;
            case R.id.prefer:
                try {
                    Class ours = Class.forName("com.example.myhp.thenewboston.Prefs");
                    Intent p = new Intent(Menu.this, ours);
                    startActivity(p);
                }
                catch(ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
                break;
            case R.id.exit:
                finish();
                break;
        }
        return false;
    }
}
