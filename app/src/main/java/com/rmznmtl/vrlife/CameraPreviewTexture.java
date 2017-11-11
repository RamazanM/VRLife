package com.rmznmtl.vrlife;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;

import java.io.IOException;

/**
 * Created by ramazan on 11/11/17.
 */

public class CameraPreviewTexture extends TextureView implements TextureView.SurfaceTextureListener {

    Context ctx;
    Camera mCamera;
    SurfaceTexture mSurface;



    public CameraPreviewTexture(Context context) {
        super(context);
        mCamera=new MyCamera().getCamera();

    }

    public CameraPreviewTexture(Context context, AttributeSet attrs) {
        super(context, attrs);
        mCamera=new MyCamera().getCamera();

    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        try {
            mCamera.setPreviewTexture(surface);
            mCamera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        mCamera.stopPreview();
        mCamera.release();
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
