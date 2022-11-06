package com.hoptech.socialmedia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.hoptech.socialmedia.R;

public class PostActivity extends AppCompatActivity {
    private ImageButton backbtn;
    private Button postBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        backbtn = findViewById(R.id.backBtn);
        postBtn = findViewById(R.id.postBtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });  postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent postActivity = new Intent(getApplicationContext(),FonctionnalityActivity.class);
                startActivity(postActivity);
            }
        });
    }
}