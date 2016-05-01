package com.soundq.android;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Main sign in activity responsible for authenticating application with user's
 * SoundCloud account
 */
public class SignInActivity extends AppCompatActivity {

    /**
     * Project 'client_id' API key for SoundCloud
     */
    private static final String CLIENT_ID = "e8a34f692645d235db9c5501f29e052f";

    /**
     * Callback path from SoundCloud connect to Android
     */
    private static final String REDIRECT_URI = new Uri.Builder().scheme("soundq")
            .authority("soundcloud")
            .appendPath("callback")
            .build().toString();

    /**
     * Response type from SoundCloud connect
     */
    private static final String RESPONSE_TYPE = "token";

    /**
     * Display type for SoundCloud connect window
     */
    private static final String DISPLAY = "popup";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // TODO splash screen (+ fade out?)

        // TODO use SoundCloud button
        Button signin = (Button) this.findViewById(R.id.button_signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.soundcloud.com/connect?" +
                        "client_id=" + CLIENT_ID +
                        "&redirect_uri=" + REDIRECT_URI +
                        "&response_type=" + RESPONSE_TYPE +
                        "&display=" + DISPLAY;

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                SignInActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);

        Uri uri = intent.getData();
        if (uri == null) {
            Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show();
        } else {
            String token = uri.getFragment().substring(uri.getFragment().indexOf("&"));
            // use token ...
        }
    }

}
