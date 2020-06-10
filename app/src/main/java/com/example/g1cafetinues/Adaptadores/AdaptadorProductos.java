package com.example.g1cafetinues.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.g1cafetinues.R;
import com.example.g1cafetinues.interfaces.DatosFactura;

import java.util.ArrayList;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.MyViewHolder> {
    private ArrayList<String> mDataset;
    DatosFactura listenerproductos;

    //manipulamos cada boton del item
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nombre;
        public TextView precio;
        public ImageView imagen;
        public Button add;
        public EditText cantidad;

        public MyViewHolder(View v) {
            super(v);
            this.nombre=v.findViewById(R.id.textView_descripcion_producto);
            this.precio=v.findViewById(R.id.textView_precio_producto);
            this.imagen=v.findViewById(R.id.foto_producto);
            this.add=v.findViewById(R.id.addRepartidor);
            this.cantidad=v.findViewById(R.id.editText_cantidad_producto);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdaptadorProductos(ArrayList<String> myDataset, DatosFactura listener) {
        this.listenerproductos=listener;
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
        //datos a enviar para crear detalle de factura
        final String id="1";
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cantidads=holder.cantidad.getText().toString();

                String nombre=holder.nombre.getText().toString();
                Float precio=Float.parseFloat(holder.precio.getText().toString());

                Integer cantidad=Integer.parseInt(cantidads);
                listenerproductos.addDatos(nombre,precio,cantidad);
                Toast.makeText(v.getContext(), "Producto agregado", Toast.LENGTH_SHORT).show();
            }
        });



    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}


