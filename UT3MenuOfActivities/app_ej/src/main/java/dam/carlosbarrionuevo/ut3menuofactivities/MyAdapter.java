package dam.carlosbarrionuevo.ut3menuofactivities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import dam.carlosbarrionuevo.ut3menuofactivities.model.Item;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public interface OnItemClickListener{
        void onItemClick(Item item);
    }

    private List<Item> myDataSet;
    private OnItemClickListener listener;

    static class MyViewHolder extends RecyclerView.ViewHolder{
        View card;
        ImageView imageView;
        TextView api;
        TextView version;
        TextView android;



        //Datos de la cardView
        public MyViewHolder(View v){
            super(v);
            this.card = v;
            this.api = v.findViewById(R.id.tv_api);
            this.imageView = v.findViewById(R.id.cv_androidImage);
            this.version = v.findViewById(R.id.tv_version);
            this.android = v.findViewById(R.id.tv_android);

        }

        public void bind(Item item, OnItemClickListener listener){
            this.imageView.setImageResource(item.getIdImagen());
            this.version.setText(item.getVersion());
            this.api.setText(String.valueOf(item.getNapi()));
            this.android.setText(item.getNombre_Version());

            this.card.setOnClickListener( v -> listener.onItemClick(item));
        }
    }
  MyAdapter(List<Item> myDataSet, OnItemClickListener listener){
        this.myDataSet = myDataSet;
        this.listener = listener;
  }

  @NonNull
  @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View a = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,parent,false);
        return  new MyViewHolder(a);
  }

  @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder,int position ){
        viewHolder.bind(myDataSet.get(position), listener);
  }

  @Override
    public int getItemCount(){
        return myDataSet.size();
  }

}
