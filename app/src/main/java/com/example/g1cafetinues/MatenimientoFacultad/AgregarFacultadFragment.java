package com.example.g1cafetinues.MatenimientoFacultad;

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
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AgregarFacultadFragment extends Fragment {

    public AgregarFacultadFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_agregar_facultad, container, false);

        Button agregar=vista.findViewById(R.id.btn_agregarAceptarFacultad);

        final TextView idFacultad=vista.findViewById(R.id.editText_agregarIdFacultad);
        final TextView nombreFacultad=vista.findViewById(R.id.editText_agregarNombreFacultad);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<String> call=apiServices.agregarFacultad(Integer.parseInt(idFacultad.getText().toString()),
                        nombreFacultad.getText().toString());

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Facultad Agregada",Toast.LENGTH_LONG).show();
                        idFacultad.setText("");
                        nombreFacultad.setText("");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                        Log.d("ERROR", "onResponse: "+t.hashCode());
                    }
                });
            }
        });

        return vista;
    }
}
