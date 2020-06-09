package com.example.g1cafetinues.MantenimientoProductos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.g1cafetinues.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultaProductosFragment extends Fragment {

    public ConsultaProductosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consulta_productos, container, false);
    }
}
