package com.soundq.android;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.io.IOException;

/**
 * Test activity for song playing
 */
public class SongPlayerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_player);

        getIntent().getExtras().get(IntentExtras.TOKEN);

        // TODO check 'streamable' field and notify user

        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mediaPlayer.setDataSource("http://api.soundcloud.com/tracks/" +
                    "7399237/stream?client_id="+SoundCloudAPI.CLIENT_ID);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
