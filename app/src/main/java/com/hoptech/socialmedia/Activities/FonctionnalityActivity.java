package com.hoptech.socialmedia.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.hoptech.socialmedia.Fragment.HomeFragment;
import com.hoptech.socialmedia.Fragment.ProfilFragment;
import com.hoptech.socialmedia.Fragment.SettingFragment;
import com.hoptech.socialmedia.R;
import com.hoptech.socialmedia.databinding.ActivityFonctionnalityBinding;

public class FonctionnalityActivity extends AppCompatActivity {
   ActivityFonctionnalityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFonctionnalityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfilFragment());
                    break;
                case R.id.setting:
                    replaceFragment(new SettingFragment());
                    break;
            }

            return true;
        });

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}