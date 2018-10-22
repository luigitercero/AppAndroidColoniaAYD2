package com.example.luigitercero.appcolonia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.luigitercero.appcolonia.ApiServer.NoticiasApiServer;
import com.example.luigitercero.appcolonia.ApiServer.PokeApiService;
import com.example.luigitercero.appcolonia.Models.NotiRequest;
import com.example.luigitercero.appcolonia.Models.Noticia;
import com.example.luigitercero.appcolonia.Models.PokeRequest;
import com.example.luigitercero.appcolonia.Models.Pokemon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotiColoniaActivity extends NavigationActivity {
    private TextView mTextMessage;
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListNotiAdapter listNotiAdapter;
    private int offset;
    private boolean aptoParaCargar;
    private Button agregarNoticia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti_colonia);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listNotiAdapter = new ListNotiAdapter(this);
        recyclerView.setAdapter(listNotiAdapter);
        recyclerView.setHasFixedSize(true);
        agregarNoticia = (Button)  findViewById(R.id.sendDatabutton2);
        final GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://35.229.53.20:3002/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();
        agregarNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noti = new Intent(NotiColoniaActivity.this,AddsNotiActivity.class);
                startActivity(noti);
            }
        });


    }

    private void obtenerDatos() {
        NoticiasApiServer service = retrofit.create(NoticiasApiServer.class);
        Call<NotiRequest> pokeRequestCall = service.getNoticia();


        pokeRequestCall.enqueue(new Callback<NotiRequest>() {
            @Override
            public void onResponse(Call<NotiRequest> call, Response<NotiRequest> response) {
                aptoParaCargar = true;
                if(response.isSuccessful()) {
                    NotiRequest notiRequest = response.body();
                    ArrayList<Noticia> listNoticia = notiRequest.getResults();

                    for (int i = 0; i < listNoticia.size(); i++) {
                        Noticia p = listNoticia.get(i);
                        Log.i("Pokedext","Pokemon "+ p.getNombre());
                    }

                    listNotiAdapter.addListPoke(listNoticia);
                }else {
                    Log.e("Pokedext","Onrespones"+ response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<NotiRequest> call, Throwable t) {
                aptoParaCargar = true;
                Log.e("Pokedext"," Onfailure: " + t.getMessage());
            }
        });
    }

}
