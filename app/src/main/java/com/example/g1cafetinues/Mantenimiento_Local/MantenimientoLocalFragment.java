package com.example.g1cafetinues.Mantenimiento_Local;

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
public class MantenimientoLocalFragment extends Fragment {
    Button add;
    Button delete;
    Button update;
    Button query;

    public MantenimientoLocalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_mantenimiento_local, container, false);

        add=vista.findViewById(R.id.btn_AgregarLocal);
        delete=vista.findViewById(R.id.btn_eliminaLocal);
        update=vista.findViewById(R.id.btn_actualizarLocal);
        query=vista.findViewById(R.id.btn_consultarLocal);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoLocalFragment_to_agregarLocalFragment);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoLocalFragment_to_actualizarLocalFragment);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoLocalFragment_to_eliminarLocalFragment);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoLocalFragment_to_consultarLocalFragment);
            }
        });

        return vista;
    }
}
