package com.example.g1cafetinues.MantenimientoEstadoPedido;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.g1cafetinues.R;

import static androidx.navigation.Navigation.findNavController;

public class MantenimientoEstadoPedidoFragment extends Fragment {
    Button add;
    Button delete;
    Button update;
    Button query;

    public MantenimientoEstadoPedidoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_mantenimiento_estado_pedido, container, false);

        add=vista.findViewById(R.id.btn_AgregarEstadoPedido);
        delete=vista.findViewById(R.id.btn_eliminaEstadoPedido);
        update=vista.findViewById(R.id.btn_actualizarEstadoPedido);
        query=vista.findViewById(R.id.btn_consultarEstadoPedido);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoEstadoPedidoFragment_to_agregarEstadoPedidoFragment);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoEstadoPedidoFragment2_to_actualizarEstadoPedidoFragment);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoEstadoPedidoFragment_to_eliminarEstadoPedidoFragment);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoEstadoPedidoFragment_to_consultarEstadoPedidoFragment);
            }
        });

        return vista;
    }
}
