package com.hoptech.socialmedia.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hoptech.socialmedia.Activities.FonctionnalityActivity;
import com.hoptech.socialmedia.Activities.PostActivity;
import com.hoptech.socialmedia.ListItem;
import com.hoptech.socialmedia.MyAdapter;
import com.hoptech.socialmedia.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<ListItem> listItems;
    private String[] name;
    private String[] firstname;
    private String[] desc;
    private int[] profile_image;
    private int[] image_post;
    private RecyclerView recyclerView;
    private EditText postField;
    private FloatingActionButton btn_post;
    private final DatabaseReference DatabaseReference = FirebaseDatabase.getInstance().getReference();



    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btn_post = view.findViewById(R.id.fab_post);
        postField = view.findViewById(R.id.post_Edit);


        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent postActivity = new Intent(view.getContext(),PostActivity.class);
                startActivity(postActivity);
            }
        });
        postField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    Intent postActivity = new Intent(view.getContext(),PostActivity.class);
                    startActivity(postActivity);
                }else{
                    Intent postActivity = new Intent(view.getContext(),PostActivity.class);
                    startActivity(postActivity);
                }

            }

        });
        postField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Intent postActivity = new Intent(view.getContext(),PostActivity.class);
                startActivity(postActivity);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Intent postActivity = new Intent(view.getContext(),PostActivity.class);
                startActivity(postActivity);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

        // Inflate the layout for this fragment
        return view ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialize();

//        DatabaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot post : snapshot.child("Post").getChildren()){
//
//                    ListItem listItem = new ListItem();
//
//                    listItems.add(listItem);
//
//                }
//
//                MyAdapter myAdapter = new MyAdapter(listItems, getContext());
//                recyclerView.setAdapter(myAdapter);
//                myAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        MyAdapter myAdapter = new MyAdapter(listItems, getContext());
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);




    }

    private void dataInitialize() {
        listItems = new ArrayList<>();

        name = new String[]{
                getString(R.string.name_1),
                getString(R.string.name_2),
                getString(R.string.name_3),
                getString(R.string.name_4),
                getString(R.string.name_5),
                getString(R.string.name_6),
                getString(R.string.name_7),
                getString(R.string.name_8),
                getString(R.string.name_9),
        };


        firstname = new String[]{
                getString(R.string.firstname_1),
                getString(R.string.firstname_2),
                getString(R.string.firstname_3),
                getString(R.string.firstname_4),
                getString(R.string.firstname_5),
                getString(R.string.firstname_6),
                getString(R.string.firstname_7),
                getString(R.string.firstname_8),
                getString(R.string.firstname_9)

        };


        desc = new String[]{
                getString(R.string.desc1),
                getString(R.string.desc2),
                getString(R.string.desc3),
                getString(R.string.desc4),
                getString(R.string.desc5),
                getString(R.string.desc6),
                getString(R.string.desc7),
                getString(R.string.desc8),
                getString(R.string.desc9)
        };


        profile_image = new int[]{
                R.drawable.profils,
                R.drawable.profils,
                R.drawable.profils,
                R.drawable.profils,
                R.drawable.profils,
                R.drawable.profils,
                R.drawable.profils,
                R.drawable.profils,
                R.drawable.profils
        };


        image_post = new int[]{
                R.drawable.team_business,
                R.drawable.team_business,
                R.drawable.team_business,
                R.drawable.team_business,
                R.drawable.team_business,
                R.drawable.team_business,
                R.drawable.team_business,
                R.drawable.team_business,
                R.drawable.team_business,

        };


        for (int i = 0; i < 9; i++) {
            ListItem listItem = new ListItem(name[i], firstname[i], desc[i], image_post[i],profile_image[i] );
            listItems.add(listItem);

        }



    }

}