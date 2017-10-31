package com.rmznmtl.vrlife;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by ramazan on 10/31/17.
 */

public class VrView extends View {
    private Bitmap bitmap=null;
    public VrView(Context context, Bitmap bmp) {
        super(context);
        bitmap=bmp;
    }

    public void setBitmap(Bitmap bmp){
        bitmap=bmp;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rectL=new Rect(0,0,100,100);
        Rect dRectL=new Rect(0,0,100,100);
        Rect rectR=new Rect(0,0,100,100);
        Rect dRectR=new Rect(0,0,100,100);

        Paint p=new Paint(Color.TRANSPARENT);

        canvas.drawBitmap(bitmap,rectL,dRectL,p);
        canvas.drawBitmap(bitmap,rectR,dRectR,p);


    }
}
