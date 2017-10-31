package com.rmznmtl.vrlife;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.vr.sdk.base.Eye;
import com.google.vr.sdk.base.GvrView;
import com.google.vr.sdk.base.HeadTransform;
import com.google.vr.sdk.base.Viewport;

import javax.microedition.khronos.egl.EGLConfig;

/**
 * Created by ramazan on 10/26/17.
 */

public class CameraPreview {
    CameraManager cameraManager;
    String camId;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CameraPreview(Context ctx) throws CameraAccessException {
        cameraManager=(CameraManager) ctx.getSystemService(Context.CAMERA_SERVICE);
        camId=cameraManager.getCameraIdList()[0];



    }
}
