package com.rmznmtl.vrlife;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import net.gotev.speech.GoogleVoiceTypingDisabledException;
import net.gotev.speech.Speech;
import net.gotev.speech.SpeechDelegate;
import net.gotev.speech.SpeechRecognitionNotAvailable;

import java.util.List;
import java.util.function.Function;

/**
 * Created by ramazan on 1/14/18.
 */

public class MySpeech {
    private Context ctx;
    private Speech SIntance;
    private SpeechDelegate delegate;
    String ResText;
    TextView tw;

    public MySpeech(Context ctx, @Nullable final VRViewActivity activity){
        this.ctx=ctx;
        this.tw=tw;
        Speech.init(ctx);
        this.SIntance=Speech.getInstance();


        this.delegate=new SpeechDelegate() {
            public void onStartOfSpeech() {
                Log.i("speech", "speech recognition is now active");
            }
            public void onSpeechRmsChanged(float value) {
            }
            public void onSpeechPartialResults(List<String> results) {
                StringBuilder str = new StringBuilder();
                for (String res : results) {
                    str.append(res).append(" ");
                }

                ResText=str.toString().trim();
                tw.setText(ResText);
            }
            public void onSpeechResult(String result) {
                ResText=result;
                tw.setText(ResText);
                activity.Command(result);
            }
        };


    }

    public void startListening() throws SpeechRecognitionNotAvailable, GoogleVoiceTypingDisabledException {
        SIntance.startListening(delegate);
    }
    public String getResult(){
        return this.ResText;
    }
    public void destroy(){
        SIntance.stopListening();
        SIntance.shutdown();
    }


}
