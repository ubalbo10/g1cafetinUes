package com.example.g1cafetinues.MantenimientoProductos;

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
public class MantenimientoProductosFragment extends Fragment {
    Button add;
    Button delete;
    Button update;
    Button query;
    public MantenimientoProductosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_mantenimiento_productos, container, false);
        add=vista.findViewById(R.id.button_add_producto);
        delete=vista.findViewById(R.id.button_eliminar_producto);
        update=vista.findViewById(R.id.button_Update_productos);
        query=vista.findViewById(R.id.button_consultar_producto);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoProductosFragment_to_agregarProductosFragment);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoProductosFragment_to_actualizarProductoFragment);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoProductosFragment_to_borrarProductosFragment);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoProductosFragment_to_consultaProductosFragment);
            }
        });
        return vista;
    }
}
