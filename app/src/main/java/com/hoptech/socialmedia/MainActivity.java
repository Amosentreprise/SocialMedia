package com.hoptech.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.hoptech.socialmedia.Activities.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView media_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.media_icon = findViewById(R.id.media_icon);
        media_icon.setTranslationY(-500);

        media_icon.animate().translationY(0).alpha(1).setDuration(3000).start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent loginPage = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginPage);
                finish();

            }
        };

        new Handler().postDelayed(runnable, 3000);
    }
}