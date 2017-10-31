package com.rmznmtl.vrlife;

import android.graphics.BitmapFactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VrView vrview=(VrView)findViewById(R.id.vr_view);

        vrview.setBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.image));



    }
}
