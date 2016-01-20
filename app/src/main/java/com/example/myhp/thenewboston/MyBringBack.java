package com.example.myhp.thenewboston;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by my hp on 11/14/2015.
 */
public class MyBringBack extends View{
    Bitmap gBall;
    Typeface font;
    float changingY;
    public MyBringBack(Context context) {
        super(context);
        gBall= BitmapFactory.decodeResource(getResources(),R.drawable.greenball);
        changingY=0;
        font=Typeface.createFromAsset(context.getAssets(),"G-Unit.ttf");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint textPaint=new Paint();
        textPaint.setARGB(50,250,100,50);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(50);
        canvas.drawText("mybringback",canvas.getWidth()/2,200,textPaint);
        textPaint.setTypeface(font);
        canvas.drawBitmap(gBall, canvas.getWidth() / 2, changingY, null);
        if(changingY<canvas.getHeight()){
            changingY+=10;
        }
        else
            changingY=0;
        Rect middleRect=new Rect();
        middleRect.set(0, 3 * canvas.getHeight() / 5, canvas.getWidth(), 4 * canvas.getHeight() / 5);
        Paint ourBlue=new Paint();
        ourBlue.setColor(Color.BLUE);
        canvas.drawRect(middleRect,ourBlue);
        invalidate();

    }
}
