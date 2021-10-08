package com.example.act02video;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends LogActivity {


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


    public void launchNextActivity(View view) {

        startActivity(new Intent(this, NextActivity.class));
    }


}

