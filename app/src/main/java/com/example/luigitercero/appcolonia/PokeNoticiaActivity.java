package com.example.luigitercero.appcolonia;

import android.os.Bundle;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.widget.TextView;

import com.example.luigitercero.appcolonia.Models.PokeRequest;
import com.example.luigitercero.appcolonia.Models.Pokemon;
import com.example.luigitercero.appcolonia.ApiServer.PokeApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeNoticiaActivity extends NavigationActivity {

    private TextView mTextMessage;
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListPokeAdapter listPokeAdapter;
    private int offset;
    private boolean aptoParaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listPokeAdapter = new ListPokeAdapter(this);
        recyclerView.setAdapter(listPokeAdapter);
        recyclerView.setHasFixedSize(true);
        final  GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i("Pokedxt", " Llegamos al final.");

                            aptoParaCargar = false;
                            offset += 20;
                            obtenerDatos(offset);
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aptoParaCargar = true;
        offset = 0;
        obtenerDatos(offset);

    }

    private void obtenerDatos(int offset) {
        PokeApiService service = retrofit.create(PokeApiService.class);
        Call<PokeRequest> pokeRequestCall = service.obtenerListaPokemon(20, offset);


        pokeRequestCall.enqueue(new Callback<PokeRequest>() {
            @Override
            public void onResponse(Call<PokeRequest> call, Response<PokeRequest> response) {
                aptoParaCargar = true;
                if(response.isSuccessful()) {
                    PokeRequest pokeRequest = response.body();
                    ArrayList<Pokemon> listPokemon = pokeRequest.getResults();

                    for (int i = 0; i < listPokemon.size(); i++) {
                        Pokemon p = listPokemon.get(i);
                        Log.i("Pokedext","Pokemon "+ p.getName());
                    }

                    listPokeAdapter.addListPoke(listPokemon);
                }else {
                    Log.e("Pokedext","Onrespones"+ response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<PokeRequest> call, Throwable t) {
                aptoParaCargar = true;
                Log.e("Pokedext"," Onfailure: " + t.getMessage());
            }
        });
    }

}
