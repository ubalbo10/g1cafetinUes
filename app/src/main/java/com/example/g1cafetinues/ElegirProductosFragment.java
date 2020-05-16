package com.example.g1cafetinues;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ElegirProductosFragment extends Fragment {


    RecyclerView recycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //simulando el arraylist
    ArrayList<String> productos=new ArrayList<String>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String producto1="COCA COLA 1.25LTS";
        String producto2="PEPSI 1.25LTS";
        String producto3="COCOA";
        String producto4="CHOCOBANANO";
        String producto5="CARNE ASADA";
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto1);
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_elegir_productos, container, false);
        //llamar recyclerview//
        recycler=vista.findViewById(R.id.Recycler_productos);
        recycler.setHasFixedSize(true);
        //grip es para poder ponerle columnas
        //layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        layoutManager = new GridLayoutManager(getActivity(),2);
        recycler.setLayoutManager(layoutManager);
        mAdapter=new AdaptadorProductos(productos);
        recycler.setAdapter(mAdapter);
        //FIN DE RECYCLER//


        return vista;
    }
}
