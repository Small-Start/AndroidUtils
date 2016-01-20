package com.example.myhp.thenewboston;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.sql.SQLException;

/**
 * Created by my hp on 1/16/2016.
 */
public class Hotornot {

    public static final String KEY_ROWID="_id";
    public static final String KEY_NAME="persons_name";
    public static final String KEY_HOTNESS="persons_hotness";
    private static final String DATABASE_NAME="Hotornotdb";
    private static final String DATABASE_TABLE="peopletable";
    private static final int DATABASE_VERSION=1;

    private Dbhelper ourhelper;
    private final Context ourcontext;
    private SQLiteDatabase ourdatabase;

    public void createentry(String sname, String shotness) {
        ContentValues cv=new ContentValues();
        cv.put(KEY_NAME,sname);
        cv.put(KEY_HOTNESS,shotness);
        ourdatabase.insert(DATABASE_TABLE,null,cv);

    }

    public String getData() {
        String[] columns=new String[] {KEY_ROWID,KEY_NAME,KEY_HOTNESS};

        Cursor c=ourdatabase.query(DATABASE_TABLE,columns,null,null,null,null,null);
        String result="";
        int irow=c.getColumnIndex(KEY_ROWID);
        int iname=c.getColumnIndex(KEY_NAME);
        int ihotness=c.getColumnIndex(KEY_HOTNESS);
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            result=result+c.getString(irow)+" "+c.getString(iname)+" "+c.getString(ihotness)+"\n";

        }


        return result;
    }


    private static class Dbhelper extends SQLiteOpenHelper {
        public Dbhelper(Context context) {
            super(context,DATABASE_NAME, null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+DATABASE_TABLE+" ("+KEY_ROWID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
        KEY_NAME+" TEXT NOT NULL, "+KEY_HOTNESS+" TEXT NOT NULL);");




        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS "+DATABASE_NAME);
            onCreate(db);
        }
    }

    public Hotornot(Context c){
    ourcontext=c;
    }

    public Hotornot open()throws SQLException{
        ourhelper=new Dbhelper(ourcontext);
        ourdatabase=ourhelper.getWritableDatabase();
        return this;
    }

    public void close(){
        ourhelper.close();
    }
}
