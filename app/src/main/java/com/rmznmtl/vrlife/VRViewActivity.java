package com.rmznmtl.vrlife;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VRViewActivity extends AppCompatActivity {

    private CameraPreviewOld cp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrview);

        final VrView vrview=(VrView)findViewById(R.id.vr_v);
        cp=new CameraPreviewOld(this,vrview);
//        vrview.setBitmap(cp.getPreview());
//        vrview.setBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.image));
    }

    @Override
    protected void onStop() {
        super.onStop();
        cp.Stop();
    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        cp.Stop();
//
//    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        cp.Stop();
//
//    }
}
