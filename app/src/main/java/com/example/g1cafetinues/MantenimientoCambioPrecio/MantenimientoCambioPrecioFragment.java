package com.example.g1cafetinues.MantenimientoCambioPrecio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.g1cafetinues.R;

import static androidx.navigation.Navigation.findNavController;

public class MantenimientoCambioPrecioFragment extends Fragment {
    Button add;
    Button delete;
    Button update;
    Button query;

    public MantenimientoCambioPrecioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_mantenimiento_cambio_precio, container, false);

        add=vista.findViewById(R.id.btn_AgregarCambioPrecio);
        delete=vista.findViewById(R.id.btn_eliminaCambioPrecio);
        update=vista.findViewById(R.id.btn_actualizarCambioPrecio);
        query=vista.findViewById(R.id.btn_consultarCambioPrecio);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoCambioPrecioFragment_to_agregarCambioPrecioFragment);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoCambioPrecioFragment_to_actualizarCambioPrecioFragment);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoCambioPrecioFragment_to_eliminarCambioPrecioFragment);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoCambioPrecioFragment_to_consultarCambioPrecioFragment);
            }
        });

        return vista;
    }
}
