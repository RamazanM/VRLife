package com.rmznmtl.vrlife;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.microedition.khronos.egl.EGLConfig;

/**
 * Created by ramazan on 10/26/17.
 */

public class CameraPreview {
    Camera camera;
    boolean isOpen=false;

    Bitmap previewBitmap=null;
    public CameraPreview(Context ctx, final VrView view) {
        camera=Camera.open();
        isOpen=true;
        Camera.Parameters parameters = camera.getParameters();
        final int PreviewSizeWidth=parameters.getPreviewSize().width,PreviewSizeHeight=parameters.getPreviewSize().height;
        final int imageFormat = parameters.getPreviewFormat();
        final Rect rect = new Rect(0, 0, PreviewSizeWidth, PreviewSizeHeight);


        final Camera.PreviewCallback previewCallback=new Camera.PreviewCallback(){
            @Override
            public void onPreviewFrame(byte[] data, Camera camera) {
                if (imageFormat == ImageFormat.NV21)
                {
                    YuvImage img = new YuvImage(data, ImageFormat.NV21, PreviewSizeWidth, PreviewSizeHeight, null);
                    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                    img.compressToJpeg(rect, 50,outStream);
                    byte[] imageBytes = outStream.toByteArray();
                    previewBitmap=BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
                    view.setBitmap(previewBitmap);
                }

            }
        };
        camera.setPreviewCallback(previewCallback);
        camera.startPreview();
    }

    public Bitmap getPreview(){
        return previewBitmap;
    }
    public void Stop(){
        if(isOpen) {
            camera.stopPreview();
        }
    }
}
