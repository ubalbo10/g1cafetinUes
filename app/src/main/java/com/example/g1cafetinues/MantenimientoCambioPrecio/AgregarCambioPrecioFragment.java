package com.example.g1cafetinues.MantenimientoCambioPrecio;

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
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AgregarCambioPrecioFragment extends Fragment {

    public AgregarCambioPrecioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_agregar_cambio_precio, container, false);

        Button agregar=vista.findViewById(R.id.btn_AgregarCambioPrecio);

        final TextView idCambioPrecio=vista.findViewById(R.id.editText_agregarCambioPrecio);

        final TextView idProducto=vista.findViewById(R.id.editText_agregarIdProducto);
        final TextView fechaCambio=vista.findViewById(R.id.editText_agregarFechaCambio);
        final TextView precioNuevo=vista.findViewById(R.id.editText_agregarPrecioNuevo);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<String> call=apiServices.agregarCambioPrecio(Integer.parseInt(idCambioPrecio.getText().toString()),
                        Integer.parseInt(idProducto.getText().toString()),fechaCambio.getText().toString(),Double.parseDouble(precioNuevo.getText().toString()));

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error Response",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Cambio Precio Agregado",Toast.LENGTH_LONG).show();
                        idCambioPrecio.setText("");
                        idProducto.setText("");
                        fechaCambio.setText("");
                        precioNuevo.setText("");

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
