package com.example.g1cafetinues.MatenimientoFacultad;

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
import com.example.g1cafetinues.clases.TLocal;
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
public class ActualizarFacultadFragment extends Fragment {

    public ActualizarFacultadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_actualizar_facultad, container, false);

        Button buscar=vista.findViewById(R.id.btn_buscarFacultad);
        Button actualizar=vista.findViewById(R.id.btn_actualizarAceptar);

        final EditText idBuscarFacultad=vista.findViewById(R.id.editText_buscarIdFacultad);
        final TextView idFacultad=vista.findViewById(R.id.editText_actulizarIdFacultad);
        final TextView nombreFacultad=vista.findViewById(R.id.editText_actualizarNombreFacultad);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<String> call=apiServices.actualizarFacultad(Integer.parseInt(idFacultad.getText().toString()),
                        nombreFacultad.getText().toString());

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error Response",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Detalle Actualizado",Toast.LENGTH_LONG).show();
                        idBuscarFacultad.setText("");
                        idFacultad.setText("");
                        nombreFacultad.setText("");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getContext(),"Error failure",Toast.LENGTH_LONG).show();
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

                Call<List<Facultad>> call=apiServices.obtenerFacultad(Integer.parseInt(idBuscarFacultad.getText().toString()));

                call.enqueue(new Callback<List<Facultad>>() {
                    @Override
                    public void onResponse(Call<List<Facultad>> call, Response<List<Facultad>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<Facultad> locales=response.body();
                        idFacultad.setText(locales.get(0).getIDFACULTAD().toString());
                        nombreFacultad.setText(locales.get(0).getNOMFACULTAD().toString());
                    }

                    @Override
                    public void onFailure(Call<List<Facultad>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return vista;
    }
}
