package edu.temple.lab7_bookshelf_dynamicui;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyAudioService extends Service {
    public MyAudioService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new AudioBinder();
    }

    class AudioBinder extends Binder {
        public MyAudioService getService() {
            return MyAudioService.this;
        }
    }

    public void playAudio() {
        new Thread() {
            @Override
            public void run() {
                
            }
        }.start();
    }
}
