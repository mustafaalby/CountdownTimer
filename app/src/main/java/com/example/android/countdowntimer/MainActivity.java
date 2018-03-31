package com.example.android.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView textView;
    Integer dakika;
    Integer saniye;
    Button button;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        seekBar=findViewById(R.id.seekBar2);
        seekBar.setMax(600);
        seekBar.setProgress(30);
        textView=findViewById(R.id.textView2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                dakika=progress/60;
                saniye=progress%60;
                textView.setText(Integer.toString(dakika)+":"+Integer.toString(saniye));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void basla(View view)
    {
        seekBar.setEnabled(false);
        button.setEnabled(false);
        CountDownTimer timer=new CountDownTimer(seekBar.getProgress()*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String a= Integer.toString(Math.round((millisUntilFinished%60000)/1000));
                textView.setText(Long.toString(millisUntilFinished/60000)+":"+a);
            }

            @Override
            public void onFinish() {
                seekBar.setEnabled(true);
                button.setEnabled(true);
            }
        }.start();
    }

}
