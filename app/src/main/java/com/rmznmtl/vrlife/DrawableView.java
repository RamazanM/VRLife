package com.rmznmtl.vrlife;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by ramazan on 12/7/17.
 */

public class DrawableView {

    private View view;
    private Bitmap drawableBitmap;
    private int width,height;
    private Rect sRect,dRect;




    public DrawableView(){
    }
    public DrawableView(View v){
        view=v;
        drawableBitmap=getViewBitmap(v);
        sRect=new Rect(0,0,drawableBitmap.getWidth(),drawableBitmap.getHeight());
        dRect=sRect;
    }
    public DrawableView(View v,int width,int height){
        view=v;
        this.width=width;
        this.height=height;
        drawableBitmap=getViewBitmap(v);
        drawableBitmap=Bitmap.createScaledBitmap(drawableBitmap,width,height,false);
        sRect=new Rect(0,0,drawableBitmap.getWidth(),drawableBitmap.getHeight());
        dRect=sRect;
    }
    public DrawableView(View v, int width, int height, Rect sRect,Rect dRect){
        view=v;
        this.width=width;
        this.height=height;
        this.sRect=sRect;
        this.dRect=dRect;
        drawableBitmap=getViewBitmap(v);
        drawableBitmap=Bitmap.createScaledBitmap(drawableBitmap,width,height,false);
    }

    public static Bitmap getViewBitmap(View v) {
        if (v.getMeasuredHeight() <= 0) {
            v.measure(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
            Bitmap b = Bitmap.createBitmap(v.getMeasuredWidth(), v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(b);
            v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
            v.draw(c);
            return b;
        }
        Bitmap b = Bitmap.createBitmap( v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
        return b;
    }

//    public static Bitmap getViewBitmap(View view) {
//        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(returnedBitmap);
//        Drawable bgDrawable =view.getBackground();
//        if (bgDrawable!=null)
//            bgDrawable.draw(canvas);
//        else
//            canvas.drawColor(Color.WHITE);
//        view.draw(canvas);
//        return returnedBitmap;
//    }

//    private Bitmap getViewBitmap(View v) {
//        v.clearFocus();
//        v.setPressed(false);
//
//        boolean willNotCache = v.willNotCacheDrawing();
//        v.setWillNotCacheDrawing(false);
//
//        // Reset the drawing cache background color to fully transparent
//        // for the duration of this operation
//        int color = v.getDrawingCacheBackgroundColor();
//        v.setDrawingCacheBackgroundColor(0);
//
//        if (color != 0) {
//            v.destroyDrawingCache();
//        }
//        v.buildDrawingCache();
//        Bitmap cacheBitmap = v.getDrawingCache();
//        if (cacheBitmap == null) {
//            Log.e("asd", "failed getViewBitmap(" + v + ")", new RuntimeException());
//            return null;
//        }
//
//        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);
//
//        // Restore the view
//        v.destroyDrawingCache();
//        v.setWillNotCacheDrawing(willNotCache);
//        v.setDrawingCacheBackgroundColor(color);
//
//        return bitmap;
//    }
//



    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Bitmap getDrawableBitmap() {
        return drawableBitmap;
    }

    public void setDrawableBitmap(Bitmap drawableBitmap) {
        this.drawableBitmap = drawableBitmap;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rect getsRect() {
        return sRect;
    }

    public void setsRect(Rect sRect) {
        this.sRect = sRect;
    }

    public Rect getdRect() {
        return dRect;
    }

    public void setdRect(Rect dRect) {
        this.dRect = dRect;
    }

}
