package com.example.g1cafetinues.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.Local;
import com.example.g1cafetinues.interfaces.LocalSeleccionado;

import java.util.List;

import static androidx.navigation.Navigation.findNavController;

public class AdaptorLocales extends RecyclerView.Adapter<AdaptorLocales.MyViewHolder> {
    private List<Local> mDataset;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nombre;
        public TextView idlocal;
        public ImageButton button;
        public MyViewHolder(View v) {
            super(v);
            this.button=v.findViewById(R.id.imageButton_locales);
            this.nombre=v.findViewById(R.id.textView_nombre_local);
            this.idlocal=v.findViewById(R.id.idlocalparapasar);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdaptorLocales(List<Local> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdaptorLocales.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_locales, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nombre.setText(mDataset.get(position).getNOMBRE());
        holder.idlocal.setText(mDataset.get(position).getIDLOCAL().toString());
        //Log.i("idlocal",IdLocal.toString());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre=holder.nombre.getText().toString();
                findNavController(v).navigate(R.id.action_homeClienteFragment_to_elegirProductosFragment22);

                LocalSeleccionado.Idlocal=Integer.parseInt(holder.idlocal.getText().toString());

                Toast.makeText(v.getContext(),nombre,Toast.LENGTH_LONG).show();

            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

