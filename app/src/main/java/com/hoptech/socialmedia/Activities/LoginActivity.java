package com.hoptech.socialmedia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hoptech.socialmedia.R;

public class LoginActivity extends AppCompatActivity {
    private Button SignupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.SignupButton= findViewById(R.id.sign_up_btn_login);
        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent directionSignup = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(directionSignup);


            }
        });
    }
}