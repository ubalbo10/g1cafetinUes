package com.example.g1cafetinues.MantenimientoEmpleados;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.Local;
import com.example.g1cafetinues.clases.Trabajador;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultarEmpleadoFragment extends Fragment {
    EditText consultarID;
    EditText mostrarID;
    EditText mostrarIDlocal;
    EditText mostrarIDfacultad;
    EditText mostrarIDubicacion;
    EditText mostrarNombre;
    EditText mostrarApellido;
    EditText mostrarTel;
    Retrofit retrofit;
    Button aceptar;
    Button limpiar;
    public ConsultarEmpleadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.UrlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_consultar_empleado, container, false);
        consultarID=vista.findViewById(R.id.editConsultaIdTrabajador);
        mostrarID=vista.findViewById(R.id.mostraridtrabajador);
        mostrarIDlocal=vista.findViewById(R.id.mostrarIdLocal);
        mostrarIDfacultad=vista.findViewById(R.id.mostratIdFacultad);
        mostrarIDubicacion=vista.findViewById(R.id.mostrarIdUbicacion);
        mostrarNombre=vista.findViewById(R.id.mostrarnombre_Empleado);
        mostrarApellido=vista.findViewById(R.id.mostrarApellido_Empleado);
        mostrarTel=vista.findViewById(R.id.mostrarTelefono_Empleado);
        aceptar=vista.findViewById(R.id.botonConsultarTrabajador);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtrabajador=consultarID.getText().toString();
                ApiServices service = retrofit.create(ApiServices.class);

                Call<Trabajador> trabajador=service.ObtenerTrabajador(idtrabajador);
                trabajador.enqueue(new Callback<Trabajador>() {
                    @Override
                    public void onResponse(Call<Trabajador> call, Response<Trabajador> response) {
                        if(response.isSuccessful()){
                            Trabajador respuesta=response.body();
                            mostrarID.setText(respuesta.getIDTRABAJADOR().toString());
                            mostrarIDlocal.setText(respuesta.getIDLOCAL().toString());
                            mostrarIDfacultad.setText(respuesta.getIDFACULTAD().toString());
                            mostrarIDubicacion.setText(respuesta.getIDUBICACION().toString());
                            mostrarNombre.setText(respuesta.getNOMTRABAJADOR().toString());
                            mostrarApellido.setText(respuesta.getAPETRABAJADOR().toString());
                            mostrarTel.setText(respuesta.getTELTRABAJADOR().toString());
                            // mostrarID.setText(respuesta.getIDTRABAJADOR().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Trabajador> call, Throwable t) {

                    }
                });
            }
        });



        return vista;
    }
}
