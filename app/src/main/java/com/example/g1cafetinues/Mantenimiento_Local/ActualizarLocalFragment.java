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
import com.example.g1cafetinues.clases.DetalleProductoPedido;
import com.example.g1cafetinues.clases.Local;
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
public class ActualizarLocalFragment extends Fragment {

    public ActualizarLocalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_actualizar_local, container, false);;

        Button buscar=vista.findViewById(R.id.btn_buscarLocal);
        Button actualizar=vista.findViewById(R.id.btn_actualizarAceptar);

        final EditText idBuscarLocal=vista.findViewById(R.id.editText_buscarIdLocal);
        final TextView idLocal=vista.findViewById(R.id.editText_actulizarIdLocal);
        final TextView idEncaragado=vista.findViewById(R.id.editText_actualizarIdEncargado);
        final TextView nombreLocal=vista.findViewById(R.id.editText_actualizarNombreLocal);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<String> call=apiServices.actualizarLocal(Integer.parseInt(idLocal.getText().toString()),
                        Integer.parseInt(idEncaragado.getText().toString()),nombreLocal.getText().toString());

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Detalle Actualizado",Toast.LENGTH_LONG).show();
                        idBuscarLocal.setText("");
                        idLocal.setText("");
                        idEncaragado.setText("");
                        nombreLocal.setText("");
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

                Call<List<TLocal>> call=apiServices.obtenerLocal(Integer.parseInt(idBuscarLocal.getText().toString()));

                call.enqueue(new Callback<List<TLocal>>() {
                    @Override
                    public void onResponse(Call<List<TLocal>> call, Response<List<TLocal>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<TLocal> locales=response.body();
                        idLocal.setText(locales.get(0).getIDLOCAL().toString());
                        idEncaragado.setText(locales.get(0).getIDENCARGADO().toString());
                        nombreLocal.setText(locales.get(0).getNOMBRELOCAL());
                    }

                    @Override
                    public void onFailure(Call<List<TLocal>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return vista;
    }
}
