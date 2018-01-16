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
import android.widget.TextView;

import net.gotev.speech.GoogleVoiceTypingDisabledException;
import net.gotev.speech.Speech;
import net.gotev.speech.SpeechRecognitionNotAvailable;

public class VRViewActivity extends AppCompatActivity {

    private CameraPreview cp;
    private VrView vrview;
    public SensorHandler sensorHandler;
    public MySpeech mySpeech;
    private DrawableBitmap takvim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrview);
        sensorHandler=new SensorHandler(this,this);
        mySpeech= new MySpeech(this,this);





        vrview=(VrView)findViewById(R.id.vr_v);

        cp=new CameraPreview(this,vrview);

        takvim=new DrawableBitmap(getResources(),R.drawable.takvim,200);
//
//        final DrawableBitmap dw=new DrawableBitmap(getResources(),R.drawable.image,500);
//
//        vrview.addCizilecekView(dw);


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

    public void  listen() throws SpeechRecognitionNotAvailable, GoogleVoiceTypingDisabledException {
        mySpeech.startListening();
    }

    public void Command(String command){
        ((TextView)findViewById(R.id.textView4)).setText("Komut: "+command);
        Log.d("asd", "Command: "+command);
        switch (command){
            case "mod Parlak":
                vrview.setMod("parlak");
                break;
            case "mod Koyu":
                vrview.setMod("koyu");
                break;
            case "Mode normal":
                vrview.setMod("normal");
                break;
            case "takvimi göster":
                if(vrview.countCizilecekView()<1)
                    vrview.addCizilecekView(takvim);
                break;
            case "takvimi gizle":
                if(vrview.countCizilecekView()>0)
                    vrview.removeCizilecekView();

            default:
                break;
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorHandler.destroy();
        mySpeech.destroy();
        if(cp!=null)cp.Stop();
        cp=null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorHandler.destroy();
        mySpeech.destroy();

        if(cp!=null)cp.Stop();
        cp=null;

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorHandler.destroy();
        mySpeech.destroy();
        if(cp!=null)cp.Stop();
        cp=null;

    }
}
