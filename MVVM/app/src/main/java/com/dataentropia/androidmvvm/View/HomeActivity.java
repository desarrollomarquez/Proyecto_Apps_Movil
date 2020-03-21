package com.dataentropia.androidmvvm.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import java.util.HashMap;
import tcs.civica.mobile.R;
import tcs.civica.mobile.helper.DatabaseHandler;
import tcs.civica.mobile.helper.Functions;
import tcs.civica.mobile.helper.SessionManager;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();
    private MaterialButton btnLogout;
    private SessionManager session;
    private DatabaseHandler db;
    private ProgressDialog pDialog;
    public  HashMap<String,String> usuario = new HashMap<String,String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        db = new DatabaseHandler(getApplicationContext());
        btnLogout = findViewById(R.id.logout);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // session manager
        session = new SessionManager(getApplicationContext());


        if (!session.isLoggedIn()) {
            Intent i = new Intent(HomeActivity.this, LoginActivity.class);
            //Intent i = new Intent(LoginActivity.this, PasswordExistsActivity.class);
            startActivity(i);
            finish();
        }

        // Hide Keyboard
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        init();
    }

    private void init() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

    }

    private void logoutUser() {
        session.setLogin(false);
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}