package com.example.g1cafetinues.MatenimientoFacultad;

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
public class MatenimientoFacultadFragment extends Fragment {
    Button add;
    Button delete;
    Button update;
    Button query;

    public MatenimientoFacultadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_matenimiento_facultad, container, false);

        add=vista.findViewById(R.id.btn_AgregarFacultad);
        delete=vista.findViewById(R.id.btn_eliminaFacultad);
        update=vista.findViewById(R.id.btn_actualizarFacultad);
        query=vista.findViewById(R.id.btn_consultarFacultad);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_matenimientoFacultadFragment_to_agregarFacultadFragment);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_matenimientoFacultadFragment_to_actualizarFacultadFragment);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_matenimientoFacultadFragment_to_eliminarFacultadFragment);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_matenimientoFacultadFragment_to_consultarFacultadFragment);
            }
        });

        return vista;
    }
}
