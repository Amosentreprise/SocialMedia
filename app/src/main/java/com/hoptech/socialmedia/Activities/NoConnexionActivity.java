package com.hoptech.socialmedia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hoptech.socialmedia.MainActivity;
import com.hoptech.socialmedia.R;

public class NoConnexionActivity extends AppCompatActivity {

    private Button retry_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_internet_dialog);
        this.retry_btn = findViewById(R.id.retry_btn);
        retry_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homePage = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homePage);
                finish();
            }
        });
    }
}