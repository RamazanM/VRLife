package com.rmznmtl.vrlife;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        final Context ctx=this;

        Button VrViewBtn =(Button)findViewById(R.id.VRViewBtn);
        Button SurfaceBtn=(Button)findViewById(R.id.SurfaceViewBtn);
        Button TextureBtn=(Button)findViewById(R.id.textureViewBtn);

            VrViewBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(ctx,VRViewActivity.class);
                    startActivity(i);
                }
            });

            SurfaceBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(ctx,SurfaceViewActivity.class);
                    startActivity(i);
                }
            });

    }
}
