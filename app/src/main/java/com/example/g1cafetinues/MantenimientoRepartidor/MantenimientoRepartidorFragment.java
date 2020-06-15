package com.example.g1cafetinues.MantenimientoRepartidor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.g1cafetinues.R;

import static androidx.navigation.Navigation.findNavController;

public class MantenimientoRepartidorFragment extends Fragment {
    Button add;
    Button delete;
    Button update;
    Button query;

    public MantenimientoRepartidorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_mantenimiento_repartidor, container, false);

        add=vista.findViewById(R.id.btn_AgregarRepartidor);
        delete=vista.findViewById(R.id.btn_eliminarRepartidor);
        update=vista.findViewById(R.id.btn_actualizarRepartidor);
        query=vista.findViewById(R.id.btn_consultarRepartidor);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoRepartidorFragment_to_agregarRepartidorFragment);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoRepartidorFragment_to_actualizarRepartidorFragment);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoRepartidorFragment_to_eliminarRepartidorFragment);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoRepartidorFragment_to_consultarRepartidorFragment);
            }
        });

        return vista;
    }
}
