
package com.example.luigitercero.appcolonia;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;

public class MainAtivity extends AppCompatActivity {
    LoginToken global;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        global = LoginToken.getInstance();
        global.setCorreo("Canche@");
        global.setIdCodigo("6");
        super.onCreate(savedInstanceState);
        finish();
        Intent Login = new Intent(MainAtivity.this,AddNotiActivity.class);
        startActivity(Login);
    }

}
