package com.example.g1cafetinues.MantenimientoPedido;

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
 * Use the {@link MantenimientoPedidoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MantenimientoPedidoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button add;
    Button delete;
    Button update;
    Button query;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MantenimientoPedidoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MantenimientoPedidoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MantenimientoPedidoFragment newInstance(String param1, String param2) {
        MantenimientoPedidoFragment fragment = new MantenimientoPedidoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_mantenimiento_pedido, container, false);
        add=vista.findViewById(R.id.button_add_pedido);
        delete=vista.findViewById(R.id.button_eliminar_pedido);
        update=vista.findViewById(R.id.button_Update_pedido);
        query=vista.findViewById(R.id.button_consultar_pedido);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoPedidoFragment_to_crearPedidoFragment);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoPedidoFragment_to_updatePedidoFragment);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoPedidoFragment_to_deletePedidoFragment);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoPedidoFragment_to_consultarPedidoFragment);
            }
        });
        return vista;
    }
}
