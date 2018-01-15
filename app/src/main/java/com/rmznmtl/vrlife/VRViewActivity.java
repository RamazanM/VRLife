package com.rmznmtl.vrlife;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class VRViewActivity extends AppCompatActivity {

    private CameraPreview cp;
    private VrView vrview;
    public static SensorHandler sensorHandler;
    public static PointerController pointerController;
    public MySpeech mySpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrview);



        vrview=(VrView)findViewById(R.id.vr_v);

        cp=new CameraPreview(this,vrview);
//
//        final DrawableBitmap dw=new DrawableBitmap(getResources(),R.drawable.image,500);
//
//        vrview.addCizilecekView(dw);

        Button btn=(Button)findViewById(R.id.button);

//        btn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if(vrview.countCizilecekView()>0)
//                    vrview.removeCizilecekView();
//                else
//                    vrview.addCizilecekView(dw);
//
//            }
//        });

    }

    public void Command(String command){

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorHandler.destroy();
        cp.Stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorHandler.destroy();
        cp.Stop();

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorHandler.destroy();
        cp.Stop();

    }
}
