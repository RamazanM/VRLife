package com.rmznmtl.vrlife;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

/**
 * Created by ramazan on 1/6/18.
 */



public class SensorHandler {
    private SensorManager mSensorManager;
    private Sensor mSensor;
    private SensorEventListener sensorEventListener;
    private Context ctx;

    public SensorHandler(Context ctx){
        this.ctx=ctx;
        mSensorManager = (SensorManager) ctx.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                Log.d("asd", "onSensorChanged: [0]"+event.values[0]+"[1]"+event.values[1]+"[2]"+event.values[2]);

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
