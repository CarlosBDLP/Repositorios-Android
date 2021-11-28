package dam.carlosbarrionuevo.ut3menuofactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import dam.carlosbarrionuevo.ut3menuofactivities.model.Item;

public class ItemDetailActivity extends AppCompatActivity {

    Item item;
    ImageView imageDetail;
    TextView api;
    TextView version;
    TextView year;
    TextView nombre_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pasarDatos();
        SetUi();
        VincularDatos();
    }

    public void pasarDatos(){

        this.item = (Item) getIntent().getSerializableExtra("card");
    }

    public void SetUi(){

        this.imageDetail = findViewById(R.id.imageDetail);
        this.version = findViewById(R.id.version);
        this.api = findViewById(R.id.api);
        this.nombre_version = findViewById(R.id.nombre_version);
        this.year = findViewById(R.id.year);
    }

    public void VincularDatos(){

        this.imageDetail.setImageResource(item.getIdImagen());
        this.version.setText(item.getVersion());
        this.api.setText(String.valueOf(item.getNapi()));
        this.nombre_version.setText(item.getNombre_Version());
        this.year.setText(String.valueOf(item.getYear()));
        this.imageDetail.setOnClickListener(view -> aWikipedia());
    }

    public void aWikipedia(){
        //Este metodo enlaza wikipedia con el url del item o card
        Uri enllaç = Uri.parse(item.getUrl());
        Intent intent = new Intent(Intent.ACTION_VIEW,enllaç);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

}