package com.example.luigitercero.appcolonia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.luigitercero.appcolonia.Models.Area;

import java.util.ArrayList;

public class ListAreaAdapter extends RecyclerView.Adapter<ListAreaAdapter.ViewHolder>{

    private ArrayList<Area> dataset;
    private Context context;
    public  ListAreaAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_area,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Area p =dataset.get(i);
        viewHolder.idArea.setText("Id: " + p.getId());
        viewHolder.nombreTextView .setText("Titulo:"+" "+ p.getNombre());
        viewHolder. descriptionTexView .setText("Descripcion"+" "+p.getDescripcion());
        viewHolder. dimensionesTexView .setText("Dimension"+" "+p.getDimension());
        viewHolder. localizacionTextView .setText("Localizacion"+" "+ p.getLocalizacion());
        viewHolder. capacidadTextView.setText("Capacidad"+" "+p.getCapacidad());
        viewHolder. imegenTextView .setText("Imagen"+" "+p.getImagen());


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addList(ArrayList<Area> listNoticia) {
        dataset.addAll(listNoticia);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView fotoImageView;
        private TextView nombreTextView;
        private TextView descriptionTexView;
        private TextView dimensionesTexView;
        private TextView localizacionTextView;
        private TextView capacidadTextView;
        private TextView imegenTextView;
        private TextView idArea;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoImageView  =(ImageView) itemView.findViewById(R.id.fotoImageView1);
            idArea=(TextView) itemView.findViewById(R.id.idTexview1);
            nombreTextView =(TextView) itemView.findViewById(R.id.nombreTextView1);
            descriptionTexView = (TextView) itemView.findViewById(R.id.descripcionTextView1);
            dimensionesTexView = (TextView) itemView.findViewById(R.id.dimensionsTextView1);
            localizacionTextView = (TextView) itemView.findViewById(R.id.localizacionTextView1);
            capacidadTextView = (TextView) itemView.findViewById(R.id.capacidadTextView1);
            imegenTextView = (TextView) itemView.findViewById(R.id.imagenTextView1);
        }
    }
}
