package com.cxz.record.sound;

import android.media.MediaRecorder;

import java.io.IOException;

/**
 * Created by chenxz on 2017/8/18.
 */

public class SoundRecorder {

    private static MediaRecorder mMediaRecorder;

    public static void startRecording(String path) throws IOException {
        if (mMediaRecorder == null)
            mMediaRecorder = new MediaRecorder();
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mMediaRecorder.setOutputFile(path);
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        mMediaRecorder.setAudioChannels(1);

        // 录制高品质录音
        mMediaRecorder.setAudioSamplingRate(44100);
        mMediaRecorder.setAudioEncodingBitRate(192000);

        mMediaRecorder.prepare();
        mMediaRecorder.start();
    }

    public static void pauseRecording(){
        if (mMediaRecorder != null){
        }

    }

    public static void stopRecording() {
        if (mMediaRecorder != null) {
            mMediaRecorder.stop();
            mMediaRecorder.reset();
            mMediaRecorder.release();
            mMediaRecorder = null;
        }
    }

}
