package com.dataentropia.androidmvvm.view;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import tcs.civica.mobile.R;
import tcs.civica.mobile.helper.DatabaseHandler;
import tcs.civica.mobile.helper.SessionManager;


public class BeginActivity extends AppCompatActivity {
    private static final String TAG = BeginActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private SessionManager session;
    private DatabaseHandler db;
    private static final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.SplashTheme);
        //setContentView(R.layout.activity_login);


        // create sqlite database
        db = new DatabaseHandler(getApplicationContext());


        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_CODE);
            return;
        }

        // Hide Keyboard
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Intent intent = new Intent(BeginActivity.this, LoginActivity.class);
        startActivity(intent);
    }

   public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(BeginActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED) {

                    Toast.makeText(this, "Instala nuevamente la AppCivica y Recuerda debes Aceptar para disfrutar de todos los servicios de Civica.", Toast.LENGTH_SHORT).show();
                    finishAffinity();
                }

            }
        }
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

}   