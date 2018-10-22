package com.example.luigitercero.appcolonia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.luigitercero.appcolonia.Models.Area;

public class NavigationActivity extends AppCompatActivity {

    private TextView mTextMessage;

    protected BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    finish();
                    Intent noticia = new Intent(NavigationActivity.this,NotiColoniaActivity.class);
                    startActivity(noticia);
                    return true;
                case R.id.navigation_dashboard:
                    finish();
                    Intent soap = new Intent(NavigationActivity.this,SoapActivity2.class);
                    startActivity(soap);
                    return true;
                case R.id.navigation_notifications:
                    Intent area = new Intent(NavigationActivity.this,AreaActivity.class);
                    startActivity(area);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation2);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
