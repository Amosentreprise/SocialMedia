package com.hoptech.socialmedia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hoptech.socialmedia.Models.SqliteDataBase;
import com.hoptech.socialmedia.R;

public class LoginActivity extends AppCompatActivity {
    SqliteDataBase myDb;
    private Button SignupButton, btn_Login;
    private EditText phone_Login, password_Login;
    private TextView forgetPassword, text_or;
    private  int OPACITY = 0;
    private ImageView logo_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.SignupButton= findViewById(R.id.sign_up_btn_login);
        this.phone_Login = findViewById(R.id.phone_Login);
        this.password_Login = findViewById(R.id.password_Login);
        this.forgetPassword = findViewById(R.id.forgetPassword);
        this.text_or = findViewById(R.id.or);
        this.btn_Login = findViewById(R.id.btn_Login);
        this.logo_Login = findViewById(R.id.logo_Login);
        myDb = new SqliteDataBase(this);
        SignupButton.setTranslationX(800);
        SignupButton.setAlpha(OPACITY);

        phone_Login.setTranslationX(800);
        phone_Login.setAlpha(OPACITY);

        password_Login.setTranslationX(800);
        password_Login.setAlpha(OPACITY);

        btn_Login.setTranslationX(800);
        btn_Login.setAlpha(OPACITY);


        logo_Login.setImageAlpha(OPACITY);
        logo_Login.setTranslationY(-800);

        text_or.setAlpha(OPACITY);


        forgetPassword.setAlpha(OPACITY);

        SignupButton.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        phone_Login.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        password_Login.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        btn_Login.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        logo_Login.animate().translationY(0).alpha(1).setDuration(2000).setStartDelay(100).start();
        text_or.animate().alpha(1).setDuration(1000).setStartDelay(600).start();
        forgetPassword.animate().alpha(1).setDuration(1000).setStartDelay(400).start();





        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent directionSignup = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(directionSignup);
                finish();


            }
        });
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validatePhone()&& validatepassword()){
                    Boolean checkPhonenumberPass= myDb.checkphonenuberpass(phone_Login.getText().toString(), password_Login.getText().toString());
                    if (checkPhonenumberPass){
                         Intent directionFonctionnality = new Intent(getApplicationContext(),FonctionnalityActivity.class );
                        startActivity(directionFonctionnality);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this,"Identifiants or password incorrect", Toast.LENGTH_LONG).show();
                    }

                }else{

                }

            }
        });
    }
    private Boolean validatePhone(){
          String phoneNumber= phone_Login.getEditableText().toString();

          if (phoneNumber.isEmpty()){
              phone_Login.setError("Phone number can't be empty");
              return false;
          } else if( phoneNumber.length()< 8 ){
              phone_Login.setError("Phone number is too low");
              return false;
          }
          else if(phoneNumber.length()>14){
              phone_Login.setError("Phone depassed limit");
              return false;
          }
          else {
               phone_Login.setError(null);
               return true;
          }
    }
    private Boolean validatepassword(){
        String password = password_Login.getEditableText().toString();

        if ( password.isEmpty()){
            password_Login.setError("Password can't be empty");
            return false;
        }  else if(password.length()<8){
            password_Login.setError("Password must depass 8 chars");
            return false;
        }
        else{
            password_Login.setError(null);
            return true;
        }
    }
}