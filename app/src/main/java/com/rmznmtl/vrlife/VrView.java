package com.rmznmtl.vrlife;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by ramazan on 10/31/17.
 */

public class VrView extends View {

    Context context;
    private Bitmap bitmap = null;
    private ArrayList<DrawableBitmap> cizilecekViewler=new ArrayList<>();
    private ColorMatrixColorFilter normal = new ColorMatrixColorFilter(new float[]{
            1, 0, 0, 0, 0,
            0, 1, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0});
    private ColorMatrixColorFilter parlak = new ColorMatrixColorFilter(new float[]{
            1.5f, 0, 0, 0, 0,
            0, 1.5f, 0, 0, 0,
            0, 0, 1.5f, 0, 0,
            0, 0, 0, 1, 0});
    private ColorMatrixColorFilter koyu = new ColorMatrixColorFilter(new float[]{
            0.7f, 0, 0, 0, 0,
            0, 0.7f, 0, 0, 0,
            0, 0, 0.7f, 0, 0,
            0, 0, 0, 1, 0});
    private ColorMatrixColorFilter seciliFiltre=normal;


    public VrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context=context;
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




            Paint p = new Paint();
            p.setColorFilter(seciliFiltre);

            float canvasRatio = canvasWidth / canvasHeigth;
            float bmpRatio = (float) bitmapWidth / (float) bitmapHeight;

            int singlePhotoWidth = canvasWidth / 2;
            int singlePhotoHeight = Math.round((singlePhotoWidth / bmpRatio));

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
            Bitmap bitmap=drawableBitmap.getDrawableBitmap();
            int canvasWidth = canvas.getWidth();
            int canvasHeigth = canvas.getHeight();
            int bitmapWidth = bitmap.getWidth();
            int bitmapHeight = bitmap.getHeight();




            Paint p = new Paint();
            p.setColorFilter(seciliFiltre);

            float canvasRatio = canvasWidth / canvasHeigth;
            float bmpRatio = (float) bitmapWidth / (float) bitmapHeight;

            int singlePhotoWidth = canvasWidth / 2;
            int singlePhotoHeight = Math.round((singlePhotoWidth / bmpRatio));

            int topPadding = Math.round((canvasHeigth - singlePhotoHeight) / 2);

            int imgLpadding = 40;//soldaki image soldan padding
            int imgRpadding = 40;//Sagdaki image sağgan padding

            Bitmap scaled = bitmap;
            scaled = Bitmap.createScaledBitmap(bitmap, singlePhotoWidth, singlePhotoHeight, false);

            Rect rectL = new Rect(0, 0, singlePhotoWidth, singlePhotoHeight);
            Rect dRectL = new Rect(imgLpadding, topPadding, singlePhotoWidth + imgLpadding, singlePhotoHeight + topPadding);
            Rect rectR = new Rect(0, 0, singlePhotoWidth * 2, singlePhotoHeight);
            Rect dRectR = new Rect(singlePhotoWidth - imgRpadding, topPadding, singlePhotoWidth * 2 - imgRpadding, singlePhotoHeight + topPadding);
            canvas.drawBitmap(scaled, rectL, dRectL, p);
            canvas.drawBitmap(scaled, rectR, dRectR, p);
        }
    }

    public void setBitmap(Bitmap bmp) {
        bitmap = bmp;
        this.invalidate();
    }

    public void setMod(String mod){
        switch (mod) {
            case "parlak":
                seciliFiltre = parlak;
                break;
            case "koyu":
                seciliFiltre = koyu;
                break;
            case "normal":
                seciliFiltre = normal;
                break;
            default:
                break;

        }
    }
}