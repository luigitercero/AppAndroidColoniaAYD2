package com.example.luigitercero.appcolonia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.luigitercero.appcolonia.ApiServer.AreaApiService;
import com.example.luigitercero.appcolonia.Models.Area;
import com.example.luigitercero.appcolonia.Models.AreaRequest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AreaActivity extends NavigationActivity {
    private TextView mTextMessage;
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListAreaAdapter listNotiAdapter;
    private int offset;
    private boolean aptoParaCargar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        init();
    }
    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listNotiAdapter = new ListAreaAdapter(this);
        recyclerView.setAdapter(listNotiAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);


        retrofit = new Retrofit.Builder()
                .baseUrl("http://35.229.53.20:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();

    }
    private void obtenerDatos() {
        AreaApiService service = retrofit.create(AreaApiService.class);
        Call<AreaRequest> pokeRequestCall = service.getArea();


        pokeRequestCall.enqueue(new Callback<AreaRequest>() {
            @Override
            public void onResponse(Call<AreaRequest> call, Response<AreaRequest> response) {
                aptoParaCargar = true;
                if(response.isSuccessful()) {
                    AreaRequest notiRequest = response.body();
                    ArrayList<Area> list= notiRequest.getResults();

                    for (int i = 0; i < list.size(); i++) {
                        Area p = list.get(i);
                        Log.i("Pokedext","Pokemon "+ p.getNombre());
                    }

                    listNotiAdapter.addList(list);
                }else {
                    Log.e("Pokedext","Onrespones"+ response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<AreaRequest> call, Throwable t) {
                aptoParaCargar = true;
                Log.e("Pokedext"," Onfailure: " + t.getMessage());
            }
        });
    }

}
