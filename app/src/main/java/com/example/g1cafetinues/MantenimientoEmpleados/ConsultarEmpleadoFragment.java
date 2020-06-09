package com.example.g1cafetinues.MantenimientoEmpleados;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.g1cafetinues.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultarEmpleadoFragment extends Fragment {

    public ConsultarEmpleadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consultar_empleado, container, false);
    }
}
