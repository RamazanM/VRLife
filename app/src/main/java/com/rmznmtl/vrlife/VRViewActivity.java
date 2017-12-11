package com.rmznmtl.vrlife;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class VRViewActivity extends AppCompatActivity {

    private CameraPreviewOld cp;
    private VrView vrview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrview);

        vrview=(VrView)findViewById(R.id.vr_v);
        cp=new CameraPreviewOld(this,vrview);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View view=findViewById(R.id.button);
        Log.d("asd", "onCreate: Width:"+view.getRight() );
        DrawableView dw=new DrawableView(view,100,100,new Rect(view.getLeft(),view.getTop(),view.getRight(),view.getBottom()),new Rect(50,50,100,100));
        vrview.addCizilecekView(dw);
    }

    @Override
    protected void onStop() {
        super.onStop();
        cp.Stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cp.Stop();

    }

    @Override
    protected void onPause() {
        super.onPause();
        cp.Stop();

    }
}
