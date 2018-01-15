package com.rmznmtl.vrlife;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ramazan on 10/31/17.
 */

public class VrView extends View {

    private Bitmap bitmap = null;

    private ArrayList<DrawableBitmap> cizilecekViewler=new ArrayList<>();

    Context context;



    public VrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context=context;
        SensorHandler handler=new SensorHandler(context);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawCamera(canvas);
        drawComponents(canvas);

        }



    public void addCizilecekView(DrawableBitmap dw){
        cizilecekViewler.add(dw);
    }
    public void removeCizilecekView(){
        cizilecekViewler.remove(cizilecekViewler.size()-1);
    }
    public int countCizilecekView(){
        return cizilecekViewler.size();
    }

    public void drawCamera(Canvas canvas) {
        if (bitmap != null) {
            int canvasWidth = canvas.getWidth();
            int canvasHeigth = canvas.getHeight();
            int bitmapWidth = bitmap.getWidth();
            int bitmapHeight = bitmap.getHeight();

            ColorMatrixColorFilter parlaklik = new ColorMatrixColorFilter(new float[]{
                    1.5f, 0, 0, 0, 0,
                    0, 1.5f, 0, 0, 0,
                    0, 0, 1.5f, 0, 0,
                    0, 0, 0, 1.5f, 0});


            Paint p = new Paint();
            p.setColorFilter(parlaklik);

            float canvasRatio = canvasWidth / canvasHeigth;
            float bmpRatio = (float) bitmapWidth / (float) bitmapHeight;

            int singlePhotoWidth = canvasWidth / 2;
            int singlePhotoHeight = (int) Math.round((singlePhotoWidth / bmpRatio));

            int topPadding = Math.round((canvasHeigth - singlePhotoHeight) / 2);

            int imgLpadding = 40;//soldaki image soldan padding
            int imgRpadding = 40;//Sagdaki image sağgan padding

            Bitmap scaled = bitmap;
            scaled = Bitmap.createScaledBitmap(bitmap, singlePhotoWidth, singlePhotoHeight, false);

            Rect rectL = new Rect(0, 0, singlePhotoWidth, singlePhotoHeight);
            Rect dRectL = new Rect(imgLpadding, topPadding, singlePhotoWidth + imgLpadding, singlePhotoHeight + topPadding);
            Rect rectR = new Rect(0, 0, singlePhotoWidth * 2, singlePhotoHeight);
            Rect dRectR = new Rect(singlePhotoWidth - imgRpadding, topPadding, singlePhotoWidth * 2 - imgRpadding, singlePhotoHeight + topPadding);
            //Kamera Görüntüsü
            canvas.drawBitmap(scaled, rectL, dRectL, p);
            canvas.drawBitmap(scaled, rectR, dRectR, p);

        }
    }




    public void drawComponents(Canvas canvas){
        for (DrawableBitmap drawableBitmap : cizilecekViewler) {
            canvas.drawBitmap(drawableBitmap.getDrawableBitmap(), drawableBitmap.getsRect(), drawableBitmap.getdRect(), new Paint());
        }
    }

    public void setBitmap(Bitmap bmp) {
        bitmap = bmp;
        this.invalidate();
    }
}