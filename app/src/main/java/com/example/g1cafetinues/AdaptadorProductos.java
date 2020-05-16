package com.example.g1cafetinues;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.MyViewHolder> {
    private ArrayList<String> mDataset;

    //manipulamos cada boton del item
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nombre;
        public TextView precio;
        public ImageView imagen;
        public MyViewHolder(View v) {
            super(v);
            this.nombre=v.findViewById(R.id.textView_descripcion_producto);
            this.precio=v.findViewById(R.id.textView_precio_producto);
            this.imagen=v.findViewById(R.id.foto_producto);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdaptadorProductos(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdaptadorProductos.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_productos_elegir, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nombre.setText(mDataset.get(position));
        holder.precio.setText("12");


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}


