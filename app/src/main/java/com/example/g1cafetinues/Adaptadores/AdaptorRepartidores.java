package com.example.g1cafetinues.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView;
import com.example.g1cafetinues.clases.Repartidor;

import androidx.recyclerview.widget.RecyclerView;

import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.Repartidor;

import java.util.List;

import static androidx.navigation.Navigation.findNavController;

public class AdaptorRepartidores extends RecyclerView.Adapter<AdaptorRepartidores.MyViewHolder> {
    private List<Repartidor> mDataset;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView idrepartidor;
        public TextView nombre;
        public TextView apellido;
        public TextView telefono;
        Button button;
        public MyViewHolder(View v) {
            super(v);
            this.idrepartidor=v.findViewById(R.id.text_idrep);
            this.nombre=v.findViewById(R.id.text_nomrep);
            this.apellido=v.findViewById(R.id.text_ApeRepartidor);
            this.telefono=v.findViewById(R.id.text_telrep);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdaptorRepartidores(List<Repartidor> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdaptorRepartidores.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repartidores, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.idrepartidor.setText(mDataset.get(position).getIDREPARTIDOR());
        holder.nombre.setText(mDataset.get(position).getNOMREPARTIDOR().toString());
        //Log.i("idlocal",IdLocal.toString());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idrepartidor=holder.idrepartidor.getText().toString();
                findNavController(v).navigate(R.id.action_mantenimientoRepartidorFragment_to_agregarRepartidorFragment);
                Toast.makeText(v.getContext(),idrepartidor,Toast.LENGTH_LONG).show();

            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

