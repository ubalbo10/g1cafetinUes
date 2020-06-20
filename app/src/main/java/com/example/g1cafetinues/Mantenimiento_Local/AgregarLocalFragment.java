package com.example.g1cafetinues.Mantenimiento_Local;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarLocalFragment extends Fragment {

    public AgregarLocalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista = inflater.inflate(R.layout.fragment_agregar_local, container, false);

        Button agregar=vista.findViewById(R.id.btn_agregarAceptarLocal);

        final TextView idLocal=vista.findViewById(R.id.editText_agregarLocal);
        final TextView idEncaragado=vista.findViewById(R.id.editText_agregarIdEncargado);
        final TextView nombreLocal=vista.findViewById(R.id.editText_agregarNombreLocal);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<String> call=apiServices.agregarLocal(Integer.parseInt(idLocal.getText().toString()),
                        Integer.parseInt(idEncaragado.getText().toString()),nombreLocal.getText().toString());

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Local Agregado",Toast.LENGTH_LONG).show();
                        idLocal.setText("");
                        idEncaragado.setText("");
                        nombreLocal.setText("");
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
