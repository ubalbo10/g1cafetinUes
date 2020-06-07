package com.example.g1cafetinues.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.Producto;

import java.util.ArrayList;

public class AdaptadorFactura extends RecyclerView.Adapter<AdaptadorFactura.MyViewHolder> {
    private ArrayList<Producto> mDataset;
    //DatosFactura listenerproductos;
    //Float totalFactura;

    //manipulamos cada boton del item
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nombre;
        public TextView id;
        public TextView precio;
        public TextView total;
        public TextView cantidad;


        public MyViewHolder(View v) {
            super(v);
            this.nombre=v.findViewById(R.id.item_nombre);
            this.precio=v.findViewById(R.id.item_precio);
            this.total=v.findViewById(R.id.item_total);
            this.id=v.findViewById(R.id.item_id);
            this.cantidad=v.findViewById(R.id.item_cantidad);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdaptadorFactura(ArrayList<Producto> myDataset) {
        //this.listenerproductos=listener;
        mDataset = myDataset;

    }


    // Create new views (invoked by the layout manager)
    @Override
    public AdaptadorFactura.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_factura, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.id.setText("1");
        holder.nombre.setText(mDataset.get(position).getNombre());
        holder.cantidad.setText(mDataset.get(position).getCantidad().toString());
        holder.precio.setText(mDataset.get(position).getPrecioUnitario().toString());
        holder.total.setText(mDataset.get(position).getTotal().toString());
        //totalFactura=totalFactura+mDataset.get(position).getTotal();
        //Facturas.totalfactura=totalFactura;





    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

