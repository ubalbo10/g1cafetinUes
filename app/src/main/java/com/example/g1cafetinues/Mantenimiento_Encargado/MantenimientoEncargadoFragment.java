package com.example.g1cafetinues.Mantenimiento_Encargado;

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
public class MantenimientoEncargadoFragment extends Fragment {
    Button add;
    Button delete;
    Button update;
    Button query;

    public MantenimientoEncargadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_mantenimiento_encargado, container, false);;

        add=vista.findViewById(R.id.btn_AgregarEncargado);
        delete=vista.findViewById(R.id.btn_EliminarEncargado);
        update=vista.findViewById(R.id.btn_ConsultarEncargado);
        query=vista.findViewById(R.id.btn_EliminarEncargado);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoEncargadoFragment_to_agregarEncargadoFragment);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoEncargadoFragment_to_actualizarEncargadoFragment);
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

                findNavController(v).navigate(R.id.action_mantenimientoEncargadoFragment_to_consultarEncargadoFragment);
            }
        });

        return vista;
    }
}
