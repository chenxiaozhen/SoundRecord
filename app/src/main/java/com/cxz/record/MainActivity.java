package com.cxz.record;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.cxz.record.util.VoiceManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_startRecord;
    private Button btn_pauseOrResumeRecord;
    private Button btn_stopRecord;

    private Button btn_startPlay;
    private Button btn_pauseOrResumePlay;
    private Button btn_stopPlay;

    private String path = Environment.getExternalStorageDirectory() + "/111_record";
    private String filePath = "";

    private VoiceManager mVoiceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_startRecord = (Button) findViewById(R.id.btn_startRecord);
        btn_stopRecord = (Button) findViewById(R.id.btn_stopRecord);
        btn_pauseOrResumeRecord = (Button) findViewById(R.id.btn_pauseOrResumeRecord);

        btn_startPlay = (Button) findViewById(R.id.btn_startPlay);
        btn_pauseOrResumePlay = (Button) findViewById(R.id.btn_pauseOrResumePlay);
        btn_stopPlay = (Button) findViewById(R.id.btn_stopPlay);

        mVoiceManager = VoiceManager.getInstance(this);

        setListener();

        setVoiceListener();

    }

    private void setVoiceListener() {
        mVoiceManager.setVoiceRecordListener(new VoiceManager.VoiceRecordCallBack() {
            @Override
            public void recDoing(long time, String strTime) {
                Log.e("TAG","----------------recDoing---------->"+time+","+strTime);
            }

            @Override
            public void recVoiceGrade(int grade) {
                Log.e("TAG","----------------recVoiceGrade---------->"+grade);
            }

            @Override
            public void recStart(boolean init) {
                Log.e("TAG","----------------recStart---------->"+init);
            }

            @Override
            public void recPause(String str) {
                Log.e("TAG","----------------recPause---------->"+str);
            }

            @Override
            public void recFinish(long length, String strLength, String path) {
                Log.e("TAG","----------------recFinish---------->"+length+","+strLength+","+path);
                filePath = path;
            }
        });

        mVoiceManager.setVoicePlayListener(new VoiceManager.VoicePlayCallBack() {
            @Override
            public void voiceTotalLength(long time, String strTime) {
                Log.e("TAG","------------------voiceTotalLength--------->"+time+","+strTime);
            }

            @Override
            public void playDoing(long time, String strTime) {
                Log.e("TAG","-----------------playDoing---------->"+time+","+strTime);
            }

            @Override
            public void playPause() {
                Log.e("TAG","-----------------playPause----------");
            }

            @Override
            public void playStart() {
                Log.e("TAG","-----------------playStart----------");
            }

            @Override
            public void playFinish() {
                Log.e("TAG","-----------------playFinish----------");
            }
        });
    }

    /**
     * 设置监听
     */
    private void setListener() {
        btn_startRecord.setOnClickListener(this);
        btn_pauseOrResumeRecord.setOnClickListener(this);
        btn_stopRecord.setOnClickListener(this);

        btn_startPlay.setOnClickListener(this);
        btn_pauseOrResumePlay.setOnClickListener(this);
        btn_stopPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_startRecord:
                mVoiceManager.startVoiceRecord(path);
                break;
            case R.id.btn_pauseOrResumeRecord:
                mVoiceManager.pauseOrStartVoiceRecord();
                break;
            case R.id.btn_stopRecord:
                mVoiceManager.stopVoiceRecord();
                break;
            case R.id.btn_startPlay:
                Log.e("TAG","---------startPlay------>"+filePath);
                mVoiceManager.startPlay(filePath);
                break;
            case R.id.btn_pauseOrResumePlay:
                mVoiceManager.continueOrPausePlay();
                break;
            case R.id.btn_stopPlay:
                mVoiceManager.stopPlay();
                break;
        }
    }
}
