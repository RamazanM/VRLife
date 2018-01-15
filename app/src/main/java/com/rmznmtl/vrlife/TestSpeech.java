package com.rmznmtl.vrlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.gotev.speech.GoogleVoiceTypingDisabledException;
import net.gotev.speech.Speech;
import net.gotev.speech.SpeechDelegate;
import net.gotev.speech.SpeechRecognitionNotAvailable;

import java.util.List;
import java.util.Locale;

public class TestSpeech extends AppCompatActivity {
    public MySpeech sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_speech);
        final TextView kelime=(TextView)findViewById(R.id.textView2);
        Button btn=(Button) findViewById(R.id.button2) ;

        sp=new MySpeech(this,null);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    sp.startListening();
                } catch (SpeechRecognitionNotAvailable speechRecognitionNotAvailable) {
                    speechRecognitionNotAvailable.printStackTrace();
                } catch (GoogleVoiceTypingDisabledException e) {
                    e.printStackTrace();
                }
            }
        });


        try {
          sp.startListening();

        } catch (SpeechRecognitionNotAvailable speechRecognitionNotAvailable) {
            speechRecognitionNotAvailable.printStackTrace();
        } catch (GoogleVoiceTypingDisabledException e) {
            e.printStackTrace();
        }

    }
    protected void onDestroy() {
        sp.destroy();
        super.onDestroy();
    }

}
