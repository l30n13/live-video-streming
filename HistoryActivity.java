
package com.example.administrator.flexiload.activity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.administrator.flexiload.R;

public class LiveVideoStream extends AppCompatActivity {

    VideoView videoView;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        videoView = (VideoView) findViewById(R.id.videoView);

        // Create a progressbar
        pDialog = new ProgressDialog(this);
        // Set progressbar title
        pDialog.setTitle("Android Video Streaming Tutorial");
        // Set progressbar message
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();

        try {
            MediaController mediacontroller = new MediaController(LiveVideoStream.this);
            mediacontroller.setAnchorView(videoView);

            videoView.setMediaController(mediacontroller);
            videoView.setVideoURI(Uri.parse("http://hkhabarcloud.purplestream.in/hkhabarorg/ngrp:hindikhabar_all/playlist.m3u8"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoView.start();
            }
        });

    }
}
