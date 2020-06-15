package com.example.g1cafetinues.MantenimientoRepartidor;

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
import com.example.g1cafetinues.clases.DetalleProductoPedido;
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
public class EliminarRepartidorFragment extends Fragment {

    public EliminarRepartidorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_eliminar_repartidor, container, false);

        Button eliminar=vista.findViewById(R.id.btn_eliminarRepartidor);

        final EditText idBuscarRepartidor=vista.findViewById(R.id.editText_eliminarRepartidor);

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<String> call=apiServices.eliminarRepartidor(Integer.parseInt(idBuscarRepartidor.getText().toString()));

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error Response",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Repartidor Eliminado",Toast.LENGTH_LONG).show();
                        idBuscarRepartidor.setText("");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getContext(),"Error Failure",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return vista;
    }
}
