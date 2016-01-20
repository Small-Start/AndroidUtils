package com.example.myhp.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by my hp on 10/6/2015.
 */
public class Cameraview extends Activity implements View.OnClickListener{

    Button b1;
    ImageView im;
    ImageButton hello;
    Intent i;
    Bitmap bmp;
    static int cameraData;
    @Override
    protected void onCreate(Bundle bund)
    {
        super.onCreate(bund);
        setContentView(R.layout.imageview);
        initialize();
        InputStream is=getResources().openRawResource(R.drawable.greenball);
        bmp= BitmapFactory.decodeStream(is);
    }
    private void initialize()
    {
     b1=(Button)findViewById(R.id.wallpaperbutton);
        im=(ImageView)findViewById(R.id.icamera);
        hello=(ImageButton)findViewById(R.id.hello);
        b1.setOnClickListener(this);
        hello.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
     switch(v.getId())
     {
         case R.id.wallpaperbutton:
             try {
                 getApplicationContext().setWallpaper(bmp);
             }
             catch(IOException e)
             {
                 e.printStackTrace();
             }
             break;

         case R.id.hello:
             i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
             startActivityForResult(i,cameraData);

             break;

     }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            im.setImageBitmap(bmp);
        }
    }
}
