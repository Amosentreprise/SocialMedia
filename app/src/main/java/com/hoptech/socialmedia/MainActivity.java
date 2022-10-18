package com.hoptech.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hoptech.socialmedia.Activities.LoginActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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