package com.example.g1cafetinues.MantenimientoUbicacion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.g1cafetinues.R;

import static androidx.navigation.Navigation.findNavController;

/**
 * A simple {@link Fragment} subclass.
 */
public class MantenimientoUbicacionFragment extends Fragment {
    Button add;
    Button delete;
    Button update;
    Button query;

    public MantenimientoUbicacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_mantenimiento_ubicacion, container, false);

        add=vista.findViewById(R.id.btn_AgregarUbicacion);
        delete=vista.findViewById(R.id.btn_eliminarUbicacion);
        update=vista.findViewById(R.id.btn_actualizarUbicacion);
        query=vista.findViewById(R.id.btn_consultarUbicacion);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoUbicacionFragment_to_agregarUbicacionFragment);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoUbicacionFragment_to_actualizarUbicacionFragment);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoUbicacionFragment_to_eliminarUbicacionFragment);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoUbicacionFragment_to_consultarUbicacionFragment);
            }
        });

        return vista;
    }
}
