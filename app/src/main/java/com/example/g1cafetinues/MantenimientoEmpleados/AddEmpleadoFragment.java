package com.example.g1cafetinues.MantenimientoEmpleados;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
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

public class AddEmpleadoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    Retrofit retrofit;
    Button aceptar;
    Button limpiar;
    EditText idEmpleado;
    EditText idFacultad;
    EditText idUbicacion;
    EditText idLocal;
    EditText Nombre;
    EditText Apellido;
    EditText tel;

    public AddEmpleadoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.UrlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        View vista=inflater.inflate(R.layout.fragment_add_empleado, container, false);
        idEmpleado=vista.findViewById(R.id.editidtrabajador);
        idLocal=vista.findViewById(R.id.editIdLocal);
        idFacultad=vista.findViewById(R.id.editidfacultad);
        idUbicacion=vista.findViewById(R.id.editIdUbicacion);
        Apellido=vista.findViewById(R.id.editApellido);
        Nombre=vista.findViewById(R.id.editNombreTrabajador);
        tel=vista.findViewById(R.id.editTelefonoEmpleado);
        aceptar=vista.findViewById(R.id.button_aceptar_agregar_empleado);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(v.getContext(),"boton",Toast.LENGTH_LONG).show();
                String idempleado=idEmpleado.getText().toString();
                String idlocal=idLocal.getText().toString();
                String idubicacion=idUbicacion.getText().toString();
                String idfacultad=idFacultad.getText().toString();
                String apellido=Apellido.getText().toString();
                String nombre=Nombre.getText().toString();
                String telefono=tel.getText().toString();
                ApiServices service = retrofit.create(ApiServices.class);
                Log.i("aqui","antes");
                service.RegistrarEmpleado(idempleado,idlocal,idubicacion,idfacultad,nombre,apellido,telefono).
                        enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.i("aqui","no finaliza");
                        if(response.isSuccessful()){
                            Log.i("aqui","dentro de on response");
                            String respuesta=response.body();
                            Log.i("respuesta",respuesta);
                            if(respuesta=="1"){
                                Toast.makeText(getActivity(),"empleado registrado",Toast.LENGTH_LONG).show();
                            }
                            if(respuesta=="0"){
                                Toast.makeText(getActivity(),"no registrado verifique los datos",Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.i("aqui","fallo");
                        Toast.makeText(getActivity(),"fallo en el WS",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

        return vista;
    }
}
