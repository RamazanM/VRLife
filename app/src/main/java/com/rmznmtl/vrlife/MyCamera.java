package com.rmznmtl.vrlife;

import android.hardware.Camera;

/**
 * Created by ramazan on 11/11/17.
 */

public class MyCamera {
    public MyCamera(){

    }
    public Camera getCamera(){
        Camera camera= Camera.open();
        return camera;
    }
}
