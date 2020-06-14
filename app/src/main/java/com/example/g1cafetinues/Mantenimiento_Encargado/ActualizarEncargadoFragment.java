package com.example.g1cafetinues.Mantenimiento_Encargado;

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
import com.example.g1cafetinues.clases.DetalleProductoPedido;
import com.example.g1cafetinues.clases.Encargado;
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
public class ActualizarEncargadoFragment extends Fragment {

    public ActualizarEncargadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_actualizar_encargado, container, false);

        Button buscar=vista.findViewById(R.id.btn_buscarEncargdo);
        Button actualizar=vista.findViewById(R.id.btn_actualizarAceptar);

        final EditText idBuscarDetalle=vista.findViewById(R.id.editText_buscarIdEncargado);
        final TextView idEncargado=vista.findViewById(R.id.editText_actulizarIdEncargado);
        final TextView nombre=vista.findViewById(R.id.editText_actualizarNombre);
        final TextView apellido=vista.findViewById(R.id.editText_actualizarAperllido);
        final TextView telefono=vista.findViewById(R.id.editText_actualizarTelefono);

        actualizar.setOnClickListener(new View.OnClickListener() {
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

                Call<Encargado> call=apiServices.actualizarEncargado(encargado.getIDENCARGADO(),encargado.getNOMBRE(),encargado.getAPELLIDO(),encargado.getTELEFONO());

                call.enqueue(new Callback<Encargado>() {
                    @Override
                    public void onResponse(Call<Encargado> call, Response<Encargado> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Detalle Actualizado",Toast.LENGTH_LONG).show();
                        idEncargado.setText("");
                        nombre.setText("");
                        apellido.setText("");
                        telefono.setText("");

                    }

                    @Override
                    public void onFailure(Call<Encargado> call, Throwable t) {
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

                Call<List<Encargado>> call=apiServices.obtenerEncargado(Integer.parseInt(idBuscarDetalle.getText().toString()));

                call.enqueue(new Callback<List<Encargado>>() {
                    @Override
                    public void onResponse(Call<List<Encargado>> call, Response<List<Encargado>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<Encargado> encargado=response.body();
                        idEncargado.setText(encargado.get(0).getIDENCARGADO().toString());
                        nombre.setText(encargado.get(0).getNOMBRE());
                        apellido.setText(encargado.get(0).getAPELLIDO());
                        telefono.setText(encargado.get(0).getTELEFONO().toString());
                    }

                    @Override
                    public void onFailure(Call<List<Encargado>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return vista;
    }
}
