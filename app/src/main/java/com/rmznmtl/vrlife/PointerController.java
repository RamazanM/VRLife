package com.rmznmtl.vrlife;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by ramazan on 1/6/18.
 */

public class PointerController {
    private int posX,posY,width,height;
    private Bitmap pointer;
    private Context ctx;
    private int treshold=50;

    private int minX,minY,maxX,maxY;

    public PointerController(Context ctx,int x,int y) {
        this.ctx=ctx;
        pointer= BitmapFactory.decodeResource(ctx.getResources(),R.drawable.aim);
        posX=x;
        posY=y;
        minX=minY=0;
        maxX=maxY=500;

    }

    public void setPos(float x,float y){
        if(posX+x*treshold>minX && posX+x*treshold<maxX && Math.abs(x)>0.1)
            posX=Math.round(posX+x*treshold);
        if(posY+y*treshold>minY && posY+y*treshold<maxY && Math.abs(y)>0.1)
            posY=Math.round(posY+y*treshold);
    }

    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
