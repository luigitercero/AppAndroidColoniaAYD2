package com.example.luigitercero.appcolonia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.luigitercero.appcolonia.Models.Pokemon;

import java.util.ArrayList;

public class ListPokeAdapter extends RecyclerView.Adapter<ListPokeAdapter.ViewHolder> {
    private ArrayList<Pokemon> dataset;
    private Context context;


    public  ListPokeAdapter(Context context) {
        this.context = context;

        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pokemon,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Pokemon p =dataset.get(i);
        viewHolder.nombreTextView.setText(p.getName());
        Glide.with(context) .load("http://pokeapi.co/media/sprites/pokemon/" + p.getNumber() + ".png")
                .load("http://pokeapi.co/media/sprites/pokemon/" + p.getNumber() + ".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.fotoImageView);

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addListPoke(ArrayList<Pokemon> listPokemon) {
        dataset.addAll(listPokemon);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView fotoImageView;
        private TextView nombreTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoImageView  =(ImageView) itemView.findViewById(R.id.fotoImageView);
            nombreTextView =(TextView) itemView.findViewById(R.id.nombreTexview);
        }
    }


}
