package com.example.luigitercero.appcolonia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luigitercero.appcolonia.ApiServer.NoticiasApiServer;
import com.example.luigitercero.appcolonia.Models.Noticia;
import com.example.luigitercero.appcolonia.Models.Noticia2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddsNotiActivity extends AppCompatActivity {
    private Button enviar;
    private Button cancelar;
    private AutoCompleteTextView title;
    private EditText descripcion;
    private LoginToken global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        global = LoginToken.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adds_noti);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        enviar = (Button) findViewById(R.id.agregarNoticiaBtm);
        cancelar = (Button) findViewById(R.id.cancelarBtm);
        title = (AutoCompleteTextView) findViewById(R.id.tituloNoticia);
        descripcion = (EditText) findViewById(R.id.textoNoticia);

        cancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent noti = new Intent(AddsNotiActivity.this,NotiColoniaActivity.class);
                startActivity(noti);
                finish();
            }
        });
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNoticia(title.getText().toString(),descripcion.getText().toString(),global.getIdCodigo());
                finish();
            }
        });

    }

    private TextView mTextMessage;
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListAreaAdapter listNotiAdapter;
    private int offset;
    private boolean aptoParaCargar;



    private void sendNoticia (String titulo, String descripcion,String id) {
        Noticia2 noticia  = new Noticia2(titulo,descripcion,id);
        sendUser(noticia);

    }
    String datos;
    private void sendUser(Noticia2 noticia) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://35.229.53.20:3002/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        NoticiasApiServer client = retrofit.create(NoticiasApiServer.class);
        Call<Noticia> call =client.crearNoticia(noticia);

        call.enqueue(new Callback<Noticia>() {


            @Override
            public void onResponse(Call<Noticia> call, Response<Noticia> response) {
                if(response.isSuccessful()) {
                    Noticia noti = response.body();

                    Log.e("Pokedext"," Onfailure: " );

                    Toast.makeText(AddsNotiActivity.this,"gg"+noti.getNombre(),Toast.LENGTH_LONG).show();
                    //datos = user.getAccess();
                    //Log.i("Pokedext","Pokemon "+ user.isAcces());

                }else {
                    Log.e("Pokedext","Onrespones"+ response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Noticia> call, Throwable t) {
                Log.e("Pokedext"," Onfailure: " + t.getMessage());
                Toast.makeText(AddsNotiActivity.this,"algo asalio mal",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
