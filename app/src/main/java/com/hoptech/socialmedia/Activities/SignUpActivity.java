package com.hoptech.socialmedia.Activities;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hoptech.socialmedia.R;

public class SignUpActivity extends AppCompatActivity {

     private Button SignupButtonlogin;
     private EditText firstname_Edit, lastname_Edit, phone_Edit, password_Edit;
     private final int OPACITY = 0;
     //creation d'un objet database pour acceder à firebase realtime database
    DatabaseReference databasereference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://socialmedia-5077d-default-rtdb.firebaseio.com/");
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
                if(validate()){
                    String firstname = firstname_Edit.getText().toString();
                    String lastname = lastname_Edit.getText().toString();
                    String phone = phone_Edit.getText().toString();
                    String password= password_Edit.getText().toString();
                    databasereference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //verifier si phone est déja enregistré une fois
                            if(snapshot.hasChild(phone)){
                                Toast.makeText(SignUpActivity.this, "Phone already register", Toast.LENGTH_SHORT).show();
                            }else{
                                //envoie des données
                                //j'ai pris le id comme identifiant unique
                                databasereference.child("Users").child(phone).child("Firstname").setValue(firstname);
                                databasereference.child("Users").child(phone).child("Lastname").setValue(lastname);
                                databasereference.child("Users").child(phone).child("Password").setValue(password);
                                Toast.makeText(SignUpActivity.this, "User Register succesfully", Toast.LENGTH_SHORT).show();
                                Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(loginActivity);
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


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
        }else {
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

