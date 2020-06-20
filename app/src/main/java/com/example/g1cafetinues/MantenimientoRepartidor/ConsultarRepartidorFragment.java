package com.example.g1cafetinues.MantenimientoRepartidor;

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
import com.example.g1cafetinues.clases.Facultad;
import com.example.g1cafetinues.clases.Repartidor;
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
public class ConsultarRepartidorFragment extends Fragment {

    public ConsultarRepartidorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_consultar_repartidor, container, false);

        Button buscar=vista.findViewById(R.id.btn_buscarRepartidor);

        final EditText idBuscarRepartidor=vista.findViewById(R.id.editText_buscarIdRepartidor);

        final TextView idRepartidor=vista.findViewById(R.id.textView_buscarIdRepartidor);
        final TextView nombre=vista.findViewById(R.id.textView_buscarNombreRepartidor);
        final TextView apellido=vista.findViewById(R.id.textView_buscarapellidoRepartidor);
        final TextView telefono=vista.findViewById(R.id.textView_buscarTelefonoRepartidor);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<List<Repartidor>> call=apiServices.obtenerRepartidor(Integer.parseInt(idBuscarRepartidor.getText().toString()));

                call.enqueue(new Callback<List<Repartidor>>() {
                    @Override
                    public void onResponse(Call<List<Repartidor>> call, Response<List<Repartidor>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error Response",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<Repartidor> repartidor=response.body();
                        idRepartidor.setText(repartidor.get(0).getIDREPARTIDOR().toString());
                        nombre.setText(repartidor.get(0).getNOMBREREPARTIDOR());
                        apellido.setText(repartidor.get(0).getAPEREPARTIDOR());
                        telefono.setText(repartidor.get(0).getTELREPARTIDOR().toString());
                    }

                    @Override
                    public void onFailure(Call<List<Repartidor>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error Failure",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return vista;
    }
}
