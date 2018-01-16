package com.rmznmtl.vrlife;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.TextView;

import net.gotev.speech.GoogleVoiceTypingDisabledException;
import net.gotev.speech.SpeechRecognitionNotAvailable;

/**
 * Created by ramazan on 1/6/18.
 */



public class SensorHandler {
    private SensorManager mSensorManager;
    private Sensor mSensor;
    private SensorEventListener sensorEventListener;
    private Context ctx;

    public SensorHandler(Context ctx, final VRViewActivity activity){
        this.ctx=ctx;
        mSensorManager = (SensorManager) ctx.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED);

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

//                Log.d("asd", "onSensorChanged: [0]"+event.values[0]+"[1]"+event.values[1]+"[2]"+event.values[2]);

                if(event.values[0]>20){
                    try {
                    activity.listen();
                } catch (SpeechRecognitionNotAvailable speechRecognitionNotAvailable) {
                    speechRecognitionNotAvailable.printStackTrace();
                } catch (GoogleVoiceTypingDisabledException e) {
                    e.printStackTrace();
                }
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        mSensorManager.registerListener(sensorEventListener,mSensor,SensorManager.SENSOR_DELAY_UI);

    }

    public SensorHandler(Context ctx, final TextView tw){
        this.ctx=ctx;
        mSensorManager = (SensorManager) ctx.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED);

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                Log.d("asd", "onSensorChanged: [0]"+event.values[0]+"[1]"+event.values[1]+"[2]"+event.values[2]);
                tw.setText("[0]"+event.values[0]+"\n[1]"+event.values[1]+"\n[2]"+event.values[2]);

//                try {
//                    activity.listen();
//                } catch (SpeechRecognitionNotAvailable speechRecognitionNotAvailable) {
//                    speechRecognitionNotAvailable.printStackTrace();
//                } catch (GoogleVoiceTypingDisabledException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        mSensorManager.registerListener(sensorEventListener,mSensor,SensorManager.SENSOR_DELAY_UI);

    }

    public void destroy(){
        mSensorManager.unregisterListener(sensorEventListener);
    }
}
