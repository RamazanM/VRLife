package com.rmznmtl.vrlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        RelativeLayout rl = new RelativeLayout(this);
//        CameraPreview2 cp=new CameraPreview2(this,0, CameraPreview2.LayoutMode.FitToParent);
//
//
//        rl.addView(cp);
//
//        setContentView(rl);
        setContentView(R.layout.activity_main);


        final VrView vrview=(VrView)findViewById(R.id.vr_view);
        final CameraPreviewOld cp=new CameraPreviewOld(this,vrview);

        vrview.setBitmap(cp.getPreview());
//        vrview.setBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.image));


    }
}
