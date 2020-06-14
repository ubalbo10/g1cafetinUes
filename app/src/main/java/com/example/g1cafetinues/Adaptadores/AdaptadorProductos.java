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
import com.example.g1cafetinues.clases.ProductoApi;
import com.example.g1cafetinues.interfaces.DatosFactura;
import com.example.g1cafetinues.interfaces.DatosUsuarioActivo;

import java.util.ArrayList;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.MyViewHolder> {
    private ArrayList<ProductoApi> mDataset;
    DatosFactura listenerproductos;

    //manipulamos cada boton del item
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nombre;
        public TextView precio;
        public ImageView imagen;
        public Button add;
        public EditText cantidad;
        public EditText Idproducto;


        public MyViewHolder(View v) {
            super(v);
            this.Idproducto=v.findViewById(R.id.editarIdProducto);
            this.nombre=v.findViewById(R.id.textView_descripcion_producto);
            this.precio=v.findViewById(R.id.textView_precio_producto);
            if(DatosUsuarioActivo.categoria=="otrosproductos"){
                this.imagen=v.findViewById(R.id.foto_producto);
                imagen.setImageResource(R.drawable.otros);
            }
            if(DatosUsuarioActivo.categoria=="bebidas"){
                this.imagen=v.findViewById(R.id.foto_producto);
                imagen.setImageResource(R.drawable.bebida);
            }
            if(DatosUsuarioActivo.categoria=="cafe"){
                this.imagen=v.findViewById(R.id.foto_producto);
                imagen.setImageResource(R.drawable.cafe);
            }
            if(DatosUsuarioActivo.categoria=="comida"){
                this.imagen=v.findViewById(R.id.foto_producto);
                imagen.setImageResource(R.drawable.comida);
            }
            this.add=v.findViewById(R.id.add);
            this.cantidad=v.findViewById(R.id.editText_cantidad_producto);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdaptadorProductos(ArrayList<ProductoApi> myDataset, DatosFactura listener) {
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

        holder.nombre.setText(mDataset.get(position).getNOMBREPRODUCTO().toString());
        holder.precio.setText(mDataset.get(position).getPRECIOUNITARIO().toString());
        holder.Idproducto.setText(mDataset.get(position).getIDPRODUCTO().toString());
        //datos a enviar para crear detalle de factura
        //final String id="1";
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cantidads=holder.cantidad.getText().toString();

                String nombre=holder.nombre.getText().toString();
                Float precio=Float.parseFloat(holder.precio.getText().toString());

                Integer cantidad=Integer.parseInt(cantidads);
                String idproducto=holder.Idproducto.getText().toString();
                listenerproductos.addDatos(idproducto,nombre,precio,cantidad);
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


