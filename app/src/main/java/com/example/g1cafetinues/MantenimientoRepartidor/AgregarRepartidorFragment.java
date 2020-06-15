package com.example.g1cafetinues.MantenimientoRepartidor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.Encargado;
import com.example.g1cafetinues.clases.Repartidor;
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
public class AgregarRepartidorFragment extends Fragment {

    public AgregarRepartidorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_agregar_repartidor, container, false);

        Button aceptar=vista.findViewById(R.id.btn_agregarRepartidor);

        final TextView idRepartidor=vista.findViewById(R.id.editText_agregarIdRepartidor);
        final TextView nombre=vista.findViewById(R.id.editText_agregarNombreRepartidor);
        final TextView apellido=vista.findViewById(R.id.editText_agregarApellidoRepartidor);
        final TextView telefono=vista.findViewById(R.id.editText_agregarTelefonoRepartidor);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<String> call=apiServices.agregarRepartidor(Integer.parseInt(idRepartidor.getText().toString()),
                        nombre.getText().toString(),apellido.getText().toString(),Integer.parseInt(telefono.getText().toString()));

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error Response",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Repartidor Agregado",Toast.LENGTH_LONG).show();
                        idRepartidor.setText("");
                        nombre.setText("");
                        apellido.setText("");
                        telefono.setText("");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getContext(),"Error failure",Toast.LENGTH_LONG).show();
                        Log.d("ERROR", "onFailure: "+ t.hashCode());
                    }
                });
            }
        });

        return vista;
    }
}
