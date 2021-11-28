package dam.carlosbarrionuevo.ut3menuofactivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dam.carlosbarrionuevo.ut3menuofactivities.model.Item;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    List<Item> myDataset = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
    }
    private void setUI(){
        recyclerView = findViewById(R.id.recyclerViewActivities);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        rellenararray();
        new ItemTouchHelper(swipe).attachToRecyclerView(recyclerView);
        mAdapter = new MyAdapter(myDataset,this);
        recyclerView.setAdapter(mAdapter);
    }
    @Override
    public void onItemClick(Item item ) {
        startActivity(new Intent(this, ItemDetailActivity.class).putExtra("card", item));
    }

    public void rellenararray(){

        Item lolipop = new Item();
        lolipop.setIdImagen(R.drawable.androidlolipop);
        lolipop.setNombre_Version("LoliPop");
        lolipop.setNapi("API: 21");
        lolipop.setYear("2014");
        lolipop.setUrl("https://es.wikipedia.org/wiki/Android_Lollipop");
        lolipop.setVersion("Version: 5.0");
        myDataset.add(lolipop);

        Item marshmallow = new Item();
        marshmallow.setIdImagen(R.drawable.androidmarshmallow);
        marshmallow.setNombre_Version("Marshmallow");
        marshmallow.setNapi("API: 23");
        marshmallow.setYear("2015");
        marshmallow.setUrl("https://es.wikipedia.org/wiki/Android_Marshmallow");
        marshmallow.setVersion("Version: 6.0");
        myDataset.add(marshmallow);

        Item nougat = new Item();
        nougat.setIdImagen(R.drawable.androidnougat);
        nougat.setNombre_Version("Nougat");
        nougat.setNapi("API: 24");
        nougat.setYear("2016");
        nougat.setUrl("https://es.wikipedia.org/wiki/Nougat");
        nougat.setVersion("Version: 7.0");
        myDataset.add(nougat);

        Item oreo = new Item();
        oreo.setIdImagen(R.drawable.androidoreo);
        oreo.setNombre_Version("Oreo");
        oreo.setNapi("API: 26");
        oreo.setYear("2017");
        oreo.setUrl("https://es.wikipedia.org/wiki/Oreo");
        oreo.setVersion("Version: 8.0");
        myDataset.add(oreo);

        Item pie = new Item();
        pie.setIdImagen(R.drawable.androidpie);
        pie.setNombre_Version("Pie");
        pie.setNapi("API: 27");
        pie.setYear("2018");
        pie.setUrl("https://es.wikipedia.org/wiki/Android_Pie");
        pie.setVersion("Version: 9.0");
        myDataset.add(pie);

        Item android10 = new Item();
        android10.setIdImagen(R.drawable.android10);
        android10.setNombre_Version("Android 10");
        android10.setNapi("API: 29");
        android10.setYear("2019");
        android10.setUrl("https://es.wikipedia.org/wiki/Android_10");
        android10.setVersion("Version: 10");
        myDataset.add(android10);

        Item android11 = new Item();
        android11.setIdImagen(R.drawable.android11);
        android11.setNombre_Version("Android 11");
        android11.setNapi("API: 30");
        android11.setYear("2020");
        android11.setUrl("https://es.wikipedia.org/wiki/Android_Pie");
        android11.setVersion("Version: 10");
        myDataset.add(android11);

        Item android12 = new Item();
        android12.setIdImagen(R.drawable.android12);
        android12.setNombre_Version("Android 11");
        android12.setNapi("API: 30");
        android12.setYear("2021");
        android12.setUrl("https://es.wikipedia.org/wiki/Android_Pie");
        android12.setVersion(" Version: 11");
        myDataset.add(android12);

    }

    ItemTouchHelper.SimpleCallback swipe = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            myDataset.remove(viewHolder.getAdapterPosition());
        }
    };

}