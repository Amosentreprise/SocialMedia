package com.hoptech.socialmedia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hoptech.socialmedia.R;

public class SignUpActivity extends AppCompatActivity {
     private Button SignupButtonlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.SignupButtonlogin = findViewById(R.id.sign_up_btn);
        SignupButtonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}