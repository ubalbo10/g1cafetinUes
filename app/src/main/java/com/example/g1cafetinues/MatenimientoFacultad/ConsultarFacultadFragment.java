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

public class ConsultarFacultadFragment extends Fragment {

    public ConsultarFacultadFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_consultar_facultad, container, false);

        Button buscar=vista.findViewById(R.id.btn_buscarFacultad);

        final EditText idBuscarFacultad=vista.findViewById(R.id.editText_buscarIdFacultad);

        final TextView idFacultad=vista.findViewById(R.id.textView_buscarIdFacultad);
        final TextView nombreFacultad=vista.findViewById(R.id.textView_buscarNombreFacultad);

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
                            Toast.makeText(getContext(),"Error response",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<Facultad> facultads=response.body();
                        idFacultad.setText(facultads.get(0).getIDFACULTAD().toString());
                        nombreFacultad.setText(facultads.get(0).getNOMFACULTAD());
                    }

                    @Override
                    public void onFailure(Call<List<Facultad>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error failure",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


        return vista;
    }
}
