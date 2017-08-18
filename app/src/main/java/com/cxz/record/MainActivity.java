package com.cxz.record;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button btn_startRecord;
    private Button btn_stopRecord;

    private Button btn_startPlay;
    private Button btn_pausePlay;
    private Button btn_continuePlay;
    private Button btn_stopPlay;

    private String path = Environment.getExternalStorageDirectory() + "/111_record.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_startRecord = (Button) findViewById(R.id.btn_startRecord);
        btn_stopRecord = (Button) findViewById(R.id.btn_stopRecord);

        btn_startPlay = (Button) findViewById(R.id.btn_startPlay);
        btn_pausePlay = (Button) findViewById(R.id.btn_pausePlay);
        btn_continuePlay = (Button) findViewById(R.id.btn_continuePlay);
        btn_stopPlay = (Button) findViewById(R.id.btn_stopPlay);

        setListener();
    }

    private void setListener(){
        btn_startRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SoundRecorder.startRecording(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                Intent intent = new Intent(MainActivity.this,RecordingService.class);
//                startService(intent);
            }
        });
        btn_stopRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundRecorder.stopRecording();
//                Intent intent = new Intent(MainActivity.this,RecordingService.class);
//                stopService(intent);
            }
        });
        btn_startPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SoundPlayer.startPlaying(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_pausePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundPlayer.pausePlaying();
            }
        });
        btn_continuePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_continuePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundPlayer.resumePlaying();
            }
        });
        btn_stopPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundPlayer.stopPlaying();
            }
        });
    }
}
