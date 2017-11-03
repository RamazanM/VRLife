package com.rmznmtl.vrlife;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ramazan on 10/31/17.
 */

public class VrView extends View {
    private Bitmap bitmap=null;

    public VrView(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
    }

    public void setBitmap(Bitmap bmp){
        bitmap=bmp;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rectL=new Rect(0,0,400,400);
        Rect dRectL=new Rect(0,0,1000,1000);
        Rect rectR=new Rect(400,0,800,400);
        Rect dRectR=new Rect(400,0,1000,1000);

        Paint p=new Paint(Color.TRANSPARENT);
        if(bitmap!=null) {
            canvas.drawBitmap(bitmap, rectL, dRectL, p);
            canvas.drawBitmap(bitmap, rectR, dRectR, p);
        }

    }
}
