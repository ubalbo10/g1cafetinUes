package com.example.g1cafetinues.MantenimientoMenu;

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
 * Use the {@link MenuMantenimientoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuMantenimientoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button add;
    Button delete;
    Button update;
    Button query;

    public MenuMantenimientoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuMantenimientoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuMantenimientoFragment newInstance(String param1, String param2) {
        MenuMantenimientoFragment fragment = new MenuMantenimientoFragment();
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
        View vista=inflater.inflate(R.layout.fragment_menu_mantenimiento, container, false);
        add=vista.findViewById(R.id.button_add_menu);
        delete=vista.findViewById(R.id.button_eliminar_menu);
        update=vista.findViewById(R.id.button_Update_menu);
        query=vista.findViewById(R.id.button_consultar_menu);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_menuMantenimientoFragment_to_addMenuFragment);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_menuMantenimientoFragment_to_actualizarMenuFragment);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_menuMantenimientoFragment_to_borrarMenuFragment);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_menuMantenimientoFragment_to_consultarMenuFragment);
            }
        });
        return vista;
    }
}