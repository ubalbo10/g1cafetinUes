package com.example.g1cafetinues.MantenimientoUbicacion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.EstadoPedido;
import com.example.g1cafetinues.clases.Ubicacion;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActualizarUbicacionFragment extends Fragment {

    public ActualizarUbicacionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_actualizar_ubicacion, container, false);

        Button buscar=vista.findViewById(R.id.btn_buscarUbicacion);
        Button actualizar=vista.findViewById(R.id.btn_actualizarUbicacion);

        final EditText idBuscarUbicacion=vista.findViewById(R.id.editText_buscarIdUbicacion);
        final TextView idUbicacion=vista.findViewById(R.id.editText_actulizarIdUbicacion);
        final TextView descUbicacion=vista.findViewById(R.id.editText_actualizarDescUbicacion);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<String> call=apiServices.actualizarUbicacion(Integer.parseInt(idUbicacion.getText().toString()),
                        descUbicacion.getText().toString());

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error Respose", Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Ubicacion Actualizado",Toast.LENGTH_LONG).show();
                        idUbicacion.setText("");
                        descUbicacion.setText("");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<List<Ubicacion>> call=apiServices.obtenerUbicacion(Integer.parseInt(idBuscarUbicacion.getText().toString()));

                call.enqueue(new Callback<List<Ubicacion>>() {
                    @Override
                    public void onResponse(Call<List<Ubicacion>> call, Response<List<Ubicacion>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<Ubicacion> ubicacions=response.body();
                        idUbicacion.setText(ubicacions.get(0).getIDUBICACION().toString());
                        descUbicacion.setText(ubicacions.get(0).getDESCUBICACION().toString());
                    }

                    @Override
                    public void onFailure(Call<List<Ubicacion>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return vista;
    }
}
