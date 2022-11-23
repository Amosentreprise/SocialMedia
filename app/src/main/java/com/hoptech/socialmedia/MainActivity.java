package com.hoptech.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.hoptech.socialmedia.Activities.LoginActivity;
import com.hoptech.socialmedia.Activities.NoConnexionActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView media_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(!checkInternet()){
            Intent connexion = new Intent(getApplicationContext(), NoConnexionActivity.class);
            startActivity(connexion);
            finish();

        }else{

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



    private Boolean checkInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wificon = connectivityManager.getNetworkInfo(connectivityManager.TYPE_WIFI);
        NetworkInfo mobileCon = connectivityManager.getNetworkInfo(connectivityManager.TYPE_MOBILE);

        return (wificon!= null && wificon.isConnected()) || (mobileCon!= null && mobileCon.isConnected()) ;

    }
}