package com.example.g1cafetinues.detalle_producto_pedido;

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
public class MantenimientoDetalleProductoPedidoFragment extends Fragment {
    Button add;
    Button delete;
    Button update;
    Button query;

    public MantenimientoDetalleProductoPedidoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_mantenimiento_detalle_producto_pedido, container, false);

        add=vista.findViewById(R.id.btn_AgregarDetalleProductoPedido);
        delete=vista.findViewById(R.id.btn_EliminarDetalleProductoPedido);
        update=vista.findViewById(R.id.btn_ActualizarDetalleProductoPedido);
        query=vista.findViewById(R.id.btn_ConsultarDetalleProductoPedido);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimimientoDetalleProductoPedidoFragment_to_agregarDetalleProductoPedidoFragment);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimimientoDetalleProductoPedidoFragment_to_actualizarDetalleProductoPedidoFragment);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimimientoDetalleProductoPedidoFragment_to_eliminarDetalleProductoPedidoFragment);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimimientoDetalleProductoPedidoFragment_to_consultarDetalleProductoPedidoFragment);
            }
        });

        return vista;
    }
}
