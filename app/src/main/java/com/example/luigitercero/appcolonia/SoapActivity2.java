package com.example.luigitercero.appcolonia;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class SoapActivity2 extends NavigationActivity {
    SoapActivity2.SoapCall soa = new SoapActivity2.SoapCall();
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soap2);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        tv = (TextView) findViewById(R.id.text1);
        new SoapActivity2.SoapCall().execute();
    }
    class SoapCall extends AsyncTask<String,Object,String> {
        ProgressBar pd;
        public static final String NAMESPACE = "http://soapv2/";
        public static final String URL = "http://35.226.225.244/soapv2/servicip?wsdl";
        public static final String METHOD_NAME = "getpagos";
        public static final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
        public int TimeOut  = 30000;
        SoapPrimitive responce;
        String out;
        @Override
        protected String doInBackground(String... strings) {
            SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = false;
            envelope.setOutputSoapObject(request);
            HttpTransportSE transportSE = new HttpTransportSE(URL,TimeOut);

            try {
                transportSE.call(SOAP_ACTION,envelope);
                responce = (SoapPrimitive) envelope.getResponse();
                out = "response: " + responce.toString();
                Log.e("respxx",responce.toString());
            }catch (Exception e) {
                e.printStackTrace();
                Log.e("Error pot no dse donde", e.toString());
                out = e.toString();

            }
            return out;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd =  (ProgressBar) findViewById(R.id.progressBar);
            pd.setVisibility(View.VISIBLE);

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pd.setVisibility(View.GONE);
            if(result != null){
                tv.setText(result);
            }else {
                Context context = getApplicationContext();
                tv.setText("Algo salio mal");
                Toast.makeText(context,"Algo salio mal",Toast.LENGTH_SHORT).show();
            }
        }
    }

}

