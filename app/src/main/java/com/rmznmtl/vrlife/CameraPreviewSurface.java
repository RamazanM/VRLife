package com.rmznmtl.vrlife;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.hardware.Camera;

import java.io.IOError;
import java.io.IOException;

/**
 * Created by ramazan on 11/11/17.
 */

public class CameraPreviewSurface extends SurfaceView implements SurfaceHolder.Callback {


    Context ctx;
    SurfaceHolder mHolder;
    Camera mCamera;


    public CameraPreviewSurface(Context context) {
        super(context);
        ctx=context;
        mHolder=getHolder();
        mHolder.addCallback(this);
        mCamera=new MyCamera().getCamera();//TODO: Düzenlenecek...

    }

    public CameraPreviewSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx=context;
        mHolder=getHolder();
        mHolder.addCallback(this);
        mCamera=new MyCamera().getCamera();//TODO: Düzenlenecek...
    }

    @Override
    public SurfaceHolder getHolder() {
        return super.getHolder();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            Log.d("asd", "surfaceCreated: ");
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        }catch (IOException ex){
            mCamera.release();
            mCamera=null;
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (null == mCamera) {
            return;
        }
        mCamera.stopPreview();
        mCamera.release();
        mCamera = null;
    }
}
