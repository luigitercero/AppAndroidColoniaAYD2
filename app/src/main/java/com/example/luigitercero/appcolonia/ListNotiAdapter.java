package com.example.luigitercero.appcolonia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;
import com.example.luigitercero.appcolonia.Models.Noticia;

import java.util.ArrayList;

public class ListNotiAdapter extends  RecyclerView.Adapter<ListNotiAdapter.ViewHolder> {

    private ArrayList<Noticia> dataset;
    private Context context;
    public  ListNotiAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_noticias,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Noticia p =dataset.get(i);
        viewHolder.nombreTextView.setText("Titulo"+p.getNombre());
        viewHolder.descriptionTexView.setText("Dato: "+ p.getDescripcion());
        viewHolder.idTextView.setText("ID "+p.getId() +"");
        viewHolder.userIdTextView.setText("Usuario ID: "+ p.getUserId() +"");

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addListPoke(ArrayList<Noticia> listNoticia) {
        dataset.addAll(listNoticia);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView fotoImageView;
        private TextView nombreTextView;
        private TextView descriptionTexView;
        private TextView idTextView;
        private TextView userIdTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoImageView  =(ImageView) itemView.findViewById(R.id.fotoImageView);
            nombreTextView =(TextView) itemView.findViewById(R.id.nombreTexview);
            descriptionTexView = (TextView) itemView.findViewById(R.id.descripcionTextView);
            idTextView = (TextView) itemView.findViewById(R.id.idTextView);
            userIdTextView = (TextView) itemView.findViewById(R.id.userIdTextView);
        }
    }

}
