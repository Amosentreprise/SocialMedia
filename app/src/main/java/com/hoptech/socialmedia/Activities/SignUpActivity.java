package com.hoptech.socialmedia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hoptech.socialmedia.R;

public class SignUpActivity extends AppCompatActivity {
     private Button SignupButtonlogin;
     private EditText firstname_Edit, lastname_Edit, phone_Edit, password_Edit;
     private final int OPACITY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.SignupButtonlogin = findViewById(R.id.sign_up_btn);
        this.firstname_Edit = findViewById(R.id.firstname_Edit);
        this.lastname_Edit = findViewById(R.id.lastname_Edit);
        this.phone_Edit = findViewById(R.id.phone_Edit);
        this.password_Edit = findViewById(R.id.password_Edit);
        //annimation
        firstname_Edit.setTranslationX(800);
        firstname_Edit.setAlpha(OPACITY);

        lastname_Edit.setTranslationX(800);
        lastname_Edit.setAlpha(OPACITY);

       phone_Edit.setTranslationX(800);
        phone_Edit.setAlpha(OPACITY);

       password_Edit.setTranslationX(800);
        password_Edit.setAlpha(OPACITY);

        SignupButtonlogin.setTranslationX(800);
        SignupButtonlogin.setAlpha(OPACITY);


        firstname_Edit.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        lastname_Edit.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        phone_Edit.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        password_Edit.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        SignupButtonlogin.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();

        SignupButtonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onBackPressed();
                Intent directionLogin = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(directionLogin);
               finish();

            }
        });
    }
}