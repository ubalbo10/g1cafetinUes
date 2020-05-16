package com.example.g1cafetinues;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeClienteFragment extends Fragment {
    Button btn_regresar;
    RecyclerView recycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //simulando el arraylist
    ArrayList<String> locales=new ArrayList<String>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String restaurante1="restaurante1";
        String restaurante2="restaurante2";
        String restaurante3="restaurante3";
        String restaurante4="restaurante4";
        String restaurante5="restaurante5";
        locales.add(restaurante1);
        locales.add(restaurante2);
        locales.add(restaurante3);
        locales.add(restaurante4);
        locales.add(restaurante5);
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_home_cliente, container, false);
        //llamar recyclerview
        recycler=vista.findViewById(R.id.Recycler_locales);
        recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);;
        recycler.setLayoutManager(layoutManager);
        mAdapter=new AdaptadorLocalesjava(locales);
        recycler.setAdapter(mAdapter);


        return vista;
    }
}
