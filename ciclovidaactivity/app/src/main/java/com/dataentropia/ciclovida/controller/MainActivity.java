package com.dataentropia.ciclovida.controller;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dataentropia.ciclovida.R;

public class MainActivity extends AppCompatActivity {

    private final static String CICLO_TAG = "Estado!";
    private String ciclo_vida;
    private TextView txv_estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_iniciar = (Button)findViewById(R.id.btn_iniciar_activity);
        Button btn_finalizar = (Button)findViewById(R.id.btn_finalizar);
        txv_estado = (TextView)findViewById(R.id.txv_estado);

        ciclo_vida = "Estado: onCreate";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }

    @Override
    protected void onStart(){
        super.onStart();
        ciclo_vida = "Estado: onStart";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        ciclo_vida = "Estado: onRestart";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }

    @Override
    protected void onResume(){
        super.onResume();
        ciclo_vida = "Estado: onResume";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }

    @Override
    protected void onPause(){
        super.onPause();
        ciclo_vida = "Estado: onPause";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }

    @Override
    protected void onStop(){
        super.onStop();
        ciclo_vida = "Estado: onStop";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ciclo_vida = "Estado: onDestroy";
        txv_estado.setText(ciclo_vida);
        android.util.Log.i(CICLO_TAG,ciclo_vida);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void iniciarActivity(View view){
        Intent starter = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(starter);
    }

    public void finalizarActivity(View view){
        finish();

    }
}
