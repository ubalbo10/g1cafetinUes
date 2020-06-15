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
public class DeleteEmpleadoFragment extends Fragment {
    Retrofit retrofit;
    Button borrar;
    EditText idempleado;


    public DeleteEmpleadoFragment() {
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
        View vista=inflater.inflate(R.layout.fragment_delete_empleado, container, false);
        borrar=vista.findViewById(R.id.Button_BorrarEmpleado);
        idempleado=vista.findViewById(R.id.edit_IdborrarEmpleado);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=idempleado.getText().toString();

                ApiServices service = retrofit.create(ApiServices.class);
                service.EliminarEmpleado(id).
                        enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if (response.isSuccessful()){
                                    String respuesta=response.body();
                                    if(respuesta=="1"){
                                        Toast.makeText(requireActivity(),"Empleado borrado",Toast.LENGTH_LONG).show();

                                    }else{
                                        Toast.makeText(requireActivity(),"Empleado NO borrado",Toast.LENGTH_LONG).show();

                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(requireActivity(),"Error ws",Toast.LENGTH_LONG).show();


                            }
                        });
            }
        });
        return vista;
    }
}
