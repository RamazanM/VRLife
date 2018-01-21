package com.rmznmtl.vrlife;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;


public class DrawableBitmap {

    private Bitmap drawableBitmap;
    private int width,height;
    private Rect sRect,dRect;
    private float ratio;


    public DrawableBitmap(Resources res, int id,int width){
        drawableBitmap= BitmapFactory.decodeResource(res,id);
        ratio=(float)drawableBitmap.getHeight()/(float)drawableBitmap.getWidth();
        Log.d("asd", "DrawableBitmap: "+ratio);
        dRect=new Rect(0,0,width, Math.round(ratio*width));
        sRect=new Rect(0,0,drawableBitmap.getWidth(),drawableBitmap.getHeight());
    }

    public Rect getdRect() { return dRect; }

    public Rect getsRect() {
        return sRect;
    }

    public Bitmap getDrawableBitmap(){
        return drawableBitmap;
    }

}
