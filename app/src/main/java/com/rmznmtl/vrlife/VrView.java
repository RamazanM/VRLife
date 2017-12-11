package com.rmznmtl.vrlife;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import java.util.ArrayList;

/**
 * Created by ramazan on 10/31/17.
 */

public class VrView extends View {
    private Bitmap bitmap = null;
    private ArrayList<DrawableView> cizilecekViewler=new ArrayList<>();

    public VrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        CalendarView cv=new CalendarView(context,attributeSet);
//        DrawableView dw=new DrawableView(cv);
//        addCizilecekView(dw);
    }

    public void setBitmap(Bitmap bmp) {
        bitmap = bmp;
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap != null) {

            int canvasWidth = canvas.getWidth();
            int canvasHeigth = canvas.getHeight();
            int bitmapWidth = bitmap.getWidth();
            int bitmapHeight = bitmap.getHeight();
            Log.d("asd", "onDraw: "+bitmapHeight);

            float canvasRatio = canvasWidth / canvasHeigth;
            float bmpRatio = (float)bitmapWidth / (float)bitmapHeight;

            int singlePhotoWidth = canvasWidth / 2;
            int singlePhotoHeight = (int) Math.round((singlePhotoWidth / bmpRatio));

            int topPadding=Math.round((canvasHeigth-singlePhotoHeight)/2);

            int imgLpadding=40;//soldaki image soldan padding
            int imgRpadding=40;//Sagdaki image sağgan padding

            Bitmap scaled=bitmap;
            scaled = Bitmap.createScaledBitmap(bitmap, singlePhotoWidth,singlePhotoHeight, false);

            Rect rectL = new Rect(0, 0, singlePhotoWidth, singlePhotoHeight);
            Rect dRectL = new Rect(imgLpadding, topPadding, singlePhotoWidth+imgLpadding, singlePhotoHeight+topPadding);
            Rect rectR = new Rect(0, 0, singlePhotoWidth*2, singlePhotoHeight);
            Rect dRectR = new Rect(singlePhotoWidth-imgRpadding, topPadding, singlePhotoWidth*2-imgRpadding, singlePhotoHeight+topPadding);

            Paint p = new Paint(Color.TRANSPARENT);

                canvas.drawBitmap(scaled, rectL, dRectL, p);
                canvas.drawBitmap(scaled, rectR, dRectR, p);
            for (DrawableView drawableView : cizilecekViewler) {
                canvas.drawBitmap(drawableView.getDrawableBitmap(),drawableView.getsRect(),drawableView.getdRect(),null);
                Log.d("asd", "onDraw: Çizildi");
            }


        }

    }

    public void addCizilecekView(DrawableView dw){
        cizilecekViewler.add(dw);
        Log.d("asd", "addCizilecekView: Eklendi");
    }




}