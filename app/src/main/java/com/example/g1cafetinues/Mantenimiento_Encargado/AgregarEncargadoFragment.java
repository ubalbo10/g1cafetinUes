package com.example.g1cafetinues.Mantenimiento_Encargado;

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
public class AgregarEncargadoFragment extends Fragment {

    public AgregarEncargadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_agregar_encargado, container, false);

        Button aceptar=vista.findViewById(R.id.btn_agregarAceptarDetalle);

        final TextView idEncargado=vista.findViewById(R.id.editText_agregarCantidad);
        final TextView nombre=vista.findViewById(R.id.editText_agregarCantidad);
        final TextView apellido=vista.findViewById(R.id.editText_agregarIdPedido);
        final TextView telefono=vista.findViewById(R.id.editText_agregarTelefono);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Encargado encargado=new Encargado();
                encargado.setIDENCARGADO(Integer.parseInt(idEncargado.getText().toString()));
                encargado.setNOMBRE(nombre.getText().toString());
                encargado.setAPELLIDO(apellido.getText().toString());
                encargado.setTELEFONO(Integer.parseInt(telefono.getText().toString()));

                Call<Encargado> call=apiServices.agregarEncargado(encargado.getIDENCARGADO(),encargado.getNOMBRE(),encargado.getAPELLIDO(),encargado.getTELEFONO());

                call.enqueue(new Callback<Encargado>() {
                    @Override
                    public void onResponse(Call<Encargado> call, Response<Encargado> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Detalle Agregado",Toast.LENGTH_LONG).show();
                        idEncargado.setText("");
                        nombre.setText("");
                        apellido.setText("");
                        telefono.setText("");
                    }

                    @Override
                    public void onFailure(Call<Encargado> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                        Log.d("ERROR", "onFailure: "+ t.hashCode());
                    }
                });
            }
        });

        return vista;
    }
}
