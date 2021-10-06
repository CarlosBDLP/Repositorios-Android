package com.example.act02video;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "LogsAndroid-1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //llamamos al metodo
        setupUI();


    }

    private void setupUI() {
        // Por medio del findViewById hacemos referencia al Boton que hemos creado  a traves de su identificador(id)
        Button btNextActivity = findViewById(R.id.btNextActivity);

        //Asociamos al boton el listener y el on clic listener que,estos metodos se utilizan para linkear a los botones
        // lo que queremos hacer, en este caso  que pase de una activity a otra
        btNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NextActivity.class));

            }
        });


    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(DEBUG_TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(DEBUG_TAG, "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(DEBUG_TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(DEBUG_TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(DEBUG_TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (isFinishing()) {
            Log.i(DEBUG_TAG, "Destroyed by User");
        } else
            Log.i(DEBUG_TAG, "Destroyed System");

    }


    public void launchNextActivity(View view) {

        startActivity(new Intent(this, NextActivity.class));
    }
}
