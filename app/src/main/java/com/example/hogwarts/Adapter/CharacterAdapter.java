package com.example.hogwarts.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hogwarts.DetailsActivity;
import com.example.hogwarts.Model.Characters;
import com.example.hogwarts.R;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.MyViewHolder> {
    Context context;
    private final List<Characters> characterList;

    public CharacterAdapter(Context context, List<Characters> characterList) {
        this.context = context;
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.each_character, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Characters character = characterList.get(position);
        Glide.with(context).load(character.getImage()).into(holder.image);
        Log.i("Testing", "onBindViewHolder: "+character.getImage());
        holder.name.setText(character.getName());

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("image", character.getImage());
                intent.putExtra("name", character.getName());
                intent.putExtra("gender", character.getGender());
                intent.putExtra("house", character.getHouse());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
