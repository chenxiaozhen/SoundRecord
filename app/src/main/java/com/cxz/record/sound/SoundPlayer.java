package com.cxz.record.sound;

import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

/**
 * Created by chenxz on 2017/8/18.
 */

public class SoundPlayer {

    private static MediaPlayer mMediaPlayer;

    public static void play(boolean isPlaying){

        if (!isPlaying){
            if (mMediaPlayer == null){

            }
        }
    }

    public static void startPlaying(String path) throws IOException {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setDataSource(path);
        mMediaPlayer.prepare();
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mMediaPlayer.start();
            }
        });
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlaying();
            }
        });
    }

    public static void pausePlaying() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }
    }

    public static void resumePlaying(){
        if (mMediaPlayer != null ){
            mMediaPlayer.start();
        }
    }

    public static void stopPlaying(){
        if (mMediaPlayer != null ){
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

}
