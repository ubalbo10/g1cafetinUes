package com.example.g1cafetinues.MantenimientoEmpleados;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.g1cafetinues.R;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateEmpleadoFragment extends Fragment {
    Retrofit retrofit;
    EditText idtrabajador;
    EditText idlocal;
    EditText idubicacion;
    EditText idfacultad;
    EditText nombretrabajador;
    EditText apellidotrabajador;
    EditText telefono;
    Button aceptar;
    Button limpiar;


    public UpdateEmpleadoFragment() {
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
        View vista=inflater.inflate(R.layout.fragment_update_empleado, container, false);
        idtrabajador=vista.findViewById(R.id.editidtrabajadorupdate);
        idlocal=vista.findViewById(R.id.editIdLocalUpdate);
        idubicacion=vista.findViewById(R.id.editIdUbicacionUpdate);
        idfacultad=vista.findViewById(R.id.editidfacultadUpdate);
        nombretrabajador=vista.findViewById(R.id.editNombreTrabajadorUpdate);
        apellidotrabajador=vista.findViewById(R.id.editApellidoUpdate);
        telefono=vista.findViewById(R.id.editTelefonoEmpleadoUpdate);
        aceptar=vista.findViewById(R.id.button_aceptar_Update);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obtener todos los datos de los edit
                String id_trabajador=idtrabajador.getText().toString();
                String id_local=idlocal.getText().toString();
                String id_ubicacion=idubicacion.getText().toString();
                String id_facultad=idfacultad.getText().toString();
                String nombre=nombretrabajador.getText().toString();
                String apellido=apellidotrabajador.getText().toString();
                String tel=telefono.getText().toString();
                ApiServices service = retrofit.create(ApiServices.class);
                service.updateEmpleado(id_trabajador,id_local,id_ubicacion,id_facultad,nombre,apellido,tel).
                        enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {

                                if(response.isSuccessful()){
                                    String respuesta=response.body();
                                    if(respuesta=="1"){
                                        Toast.makeText(requireActivity(),"Empleado actualizado",Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(requireActivity(),"Empleado No actualizado verifique su id",Toast.LENGTH_LONG).show();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(requireActivity(),"fallo WS",Toast.LENGTH_LONG).show();
                            }
                        });




            }
        });

        return vista;
    }
}
