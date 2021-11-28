package dam.carlosbarrionuevo.ut3menuofactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] myDataset ={"Activity1","Activity2","Activity3"};

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

        mAdapter = new MyAdapter(myDataset,this);
        recyclerView.setAdapter(mAdapter);
    }
    @Override
    public void onItemClick(String activityName){
        Toast.makeText(this, activityName, Toast.LENGTH_LONG).show();
        try {
            startActivity(new Intent(this,Class.forName(getPackageName()+"."+activityName)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}