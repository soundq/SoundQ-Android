package com.soundq.android;

import android.net.Uri;

/**
 * Interface for the SoundCloudAPI
 */
public interface SoundCloudAPI {

    /**
     * Project 'client_id' API key for SoundCloud
     */
    String CLIENT_ID = "e8a34f692645d235db9c5501f29e052f";

    /**
     * Callback path from SoundCloud connect to Android
     */
    String REDIRECT_URI = new Uri.Builder().scheme("soundq")
            .authority("soundcloud")
            .appendPath("callback")
            .build().toString();

    /**
     * Response type from SoundCloud connect
     */
    String RESPONSE_TYPE = "token";

}
