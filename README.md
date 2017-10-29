# SoundRecord（Android原生录音及播放功能的实现）

- 实现录音功能，提供开始录音、暂停以及继续功能

```
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
      mVoiceManager.startVoiceRecord(path); // 开始录音
      mVoiceManager.pauseOrStartVoiceRecord(); // 暂停、继续录音
      mVoiceManager.stopVoiceRecord(); // 停止录音
```

- 实现播放功能，提供开始播放、暂停以及继续功能
```
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
        mVoiceManager.startPlay(filePath); // 开始播放
        mVoiceManager.continueOrPausePlay(); // 暂停、继续播放
        mVoiceManager.stopPlay(); // 停止播放
```
