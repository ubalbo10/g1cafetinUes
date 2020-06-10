package com.example.g1cafetinues.ui.MantenimientoRepartidor;

import android.os.Bundle;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.g1cafetinues.clases.Repartidor;
import com.example.g1cafetinues.interfaces.UrlApi;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.Adaptadores.AdaptorRepartidores;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.g1cafetinues.R;

import static androidx.navigation.Navigation.findNavController;


public class MantenimientoRepartidorFragment extends Fragment{

    ApiServices apiServices;
    EditText editIdRepartidor;
    EditText editNomRepartidor;

    Button add;
    Button eliminar;
    Button editar;
    Button consultar;
    TextView txtIdRepartidor;




    public MantenimientoRepartidorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_mantenimiento_repartidor, container, false);
        add=vista.findViewById(R.id.addRepartidor);
        eliminar=vista.findViewById(R.id.eliminarRepartidor);
        editar=vista.findViewById(R.id.editarRepartidor);
        consultar=vista.findViewById(R.id.obtenerRepartidor);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoRepartidorFragment_to_addRepartidorFragment);
            }
        });
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoRepartidorFragment_to_agregarRepartidorFragment);
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoRepartidorFragment_to_eliminarRepartidorFragment);
            }
        });
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findNavController(v).navigate(R.id.action_mantenimientoRepartidorFragment_to_obtenerRepartidorFragment);
            }
        });
        return vista;
    }

}
