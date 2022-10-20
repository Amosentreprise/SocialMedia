package com.hoptech.socialmedia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hoptech.socialmedia.Models.SqliteDataBase;
import com.hoptech.socialmedia.R;

public class SignUpActivity extends AppCompatActivity {
      SqliteDataBase myDb;
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
        //connexion  avec la base de données
        myDb = new SqliteDataBase(this);
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
                if(validate()){
                    //insertion des valeurs dans la base de données
                    Boolean isInserted= myDb.insertData(firstname_Edit.getText().toString(),lastname_Edit.getText().toString(),
                            phone_Edit.getText().toString(),password_Edit.getText().toString());

                    //verification
                    if (isInserted == true){
                        Toast.makeText(SignUpActivity.this,"Account created succefully",Toast.LENGTH_LONG).show();
                        Intent directionLogin = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(directionLogin);
                        finish();

                    }else{
                        Toast.makeText(SignUpActivity.this,"Please retry",Toast.LENGTH_LONG).show();

                    }

                }


            }
        });
    }

    //validation des données
    private boolean validateFirstname(){
        String value = firstname_Edit.getText().toString().trim();

        if(value.isEmpty()){
            firstname_Edit.setError("firstname field is empty");
            return false;
        }else if(value.length() <= 2){
            firstname_Edit.setError("your firstname is incorrect ");
            return false;
        }else{
            return true;
        }
    }

    private boolean validateLastname(){
        String value = lastname_Edit.getText().toString().trim();

        if(value.isEmpty()){
            lastname_Edit.setError("lastname field is empty");
            return false;
        }else if(value.length() <= 2){
            lastname_Edit.setError("your lastname is incorrect ");
            return false;
        }else{
            return true;
        }
    }

    private boolean validatePhone(){
        String value = phone_Edit.getText().toString().trim();

        if(value.isEmpty()){
            phone_Edit.setError("phone field is empty");
            return false;
        }else if(value.length() < 8){
            phone_Edit.setError("your phone number is too low");
            return false;
        } else if(value.length() > 14){
        phone_Edit.setError("your phone depassed the limit");
        return false;
    }else{
            return true;
        }
    }

    private boolean validatePassword(){
        String value = password_Edit.getText().toString().trim();

        if(value.isEmpty()){
            password_Edit.setError("password field is empty");
            return false;
        }else if(value.length() < 8){
            password_Edit.setError("your must depassed 8 characters");
            return false;
        }else{
            return true;
        }
    }
    //validation all
    private boolean validate(){
        if(validateFirstname() && validateLastname() && validatePhone() && validatePassword()){
            return true;
        }else{
            return false;
        }
    }
}

