package com.hoptech.socialmedia.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.hoptech.socialmedia.R;

import java.net.URI;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private CircleImageView profile_image;
    private TextView nom_profile, prenom_profile,tel_profile;
    private Button bouton_profile;
    public int OPACITY=0;
    DatabaseReference databasereference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://socialmedia-5077d-default-rtdb.firebaseio.com/");
    //private URI imageUri;
    //private String myUri = "";
    //private StorageTask uploadTask;
    //private StorageReference StorageProfilePics;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int mRequestCode;
    private int mResultCode;



    public ProfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfilFragment newInstance(String param1, String param2) {
        ProfilFragment fragment = new ProfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.profile_image= view.findViewById(R.id.profile_image);
        this.nom_profile = view.findViewById(R.id.nom_profile);
        this.prenom_profile = view.findViewById(R.id.prenom_profile);
        this.tel_profile = view.findViewById(R.id.tel_profile);
        this.bouton_profile = view.findViewById(R.id.bouton_profile);

        profile_image.setTranslationY(-800);
        profile_image.setAlpha(OPACITY);

        nom_profile.setTranslationX(800);
        nom_profile.setAlpha(OPACITY);

        prenom_profile.setTranslationX(800);
        prenom_profile.setAlpha(OPACITY);

        tel_profile.setTranslationX(800);
        tel_profile.setAlpha(OPACITY);

        bouton_profile.setTranslationX(800);
        bouton_profile.setAlpha(OPACITY);

        profile_image.animate().translationY(0).alpha(1).setDuration(2000).setStartDelay(500).start();
        nom_profile.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        prenom_profile.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(200).start();
       tel_profile.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        bouton_profile.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();

        databasereference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                nom_profile.setText(snapshot.child("Users").child("Fistname").getValue(String.class));
                prenom_profile.setText(snapshot.child("Users").child("Laststname").getValue(String.class));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }






}