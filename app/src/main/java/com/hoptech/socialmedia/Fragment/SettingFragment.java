package com.hoptech.socialmedia.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hoptech.socialmedia.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class SettingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView langue, mode,info,deconnexion;
    public int OPACITY=0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SettingFragment() {
        // Required empty public constructor
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
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.langue = view.findViewById(R.id.langue_text);
        this.mode = view.findViewById(R.id.mode_text);
        this.info = view.findViewById(R.id.apropos_text);
        this.deconnexion= view.findViewById(R.id.deconnexion_text);

        langue.setTranslationX(800);
        langue.setAlpha(OPACITY);

        mode.setTranslationX(800);
        mode.setAlpha(OPACITY);

        info.setTranslationX(800);
        info.setAlpha(OPACITY);

        deconnexion.setTranslationX(800);
        deconnexion.setAlpha(OPACITY);


        langue.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        mode.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        info.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        deconnexion.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();


    }
}