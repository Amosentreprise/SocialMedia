package com.hoptech.socialmedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<ListItem> listItems;
    Context context;

    public MyAdapter(ArrayList<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_list_item,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        ListItem listItem = listItems.get(position);

        holder.name.setText(listItem.getName());
        holder.firstname.setText(listItem.getFirstname());
        holder.description.setText(listItem.getDescription());
        holder.profile_image.setImageResource(listItem.getProfile_image());
        holder.image_post.setImageResource(listItem.getImage_post());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name, firstname,description;
        public ShapeableImageView image_post;
        public CircleImageView profile_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name_id);
            firstname = (TextView) itemView.findViewById(R.id.firsname_id);
            description = (TextView) itemView.findViewById(R.id.desc);
            image_post = (ShapeableImageView) itemView.findViewById(R.id.image_post);
            profile_image  = (CircleImageView) itemView.findViewById(R.id.profile_image);
        }
    }
}
