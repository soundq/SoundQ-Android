package com.soundq.android;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Main sign in activity responsible for authenticating application with user's
 * SoundCloud account
 */
public class SignInActivity extends AppCompatActivity {

    /**
     * Display type for SoundCloud connect window
     */
    private static final String DISPLAY = "popup";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signin);

        ImageView connect = (ImageView) this.findViewById(R.id.image_connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.soundcloud.com/connect?" +
                        "client_id=" + SoundCloudAPI.CLIENT_ID +
                        "&redirect_uri=" + SoundCloudAPI.REDIRECT_URI +
                        "&response_type=" + SoundCloudAPI.RESPONSE_TYPE +
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
