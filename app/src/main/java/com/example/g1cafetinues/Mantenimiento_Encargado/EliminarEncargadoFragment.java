package com.example.g1cafetinues.Mantenimiento_Encargado;

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
public class EliminarEncargadoFragment extends Fragment {

    public EliminarEncargadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_eliminar_encargado, container, false);

        Button eliminar=vista.findViewById(R.id.btn_eliminarEncargado);

        final EditText idBuscarDetalle=vista.findViewById(R.id.editText_eliminarEncargado);

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<List<DetalleProductoPedido>> call=apiServices.eliminarEncargado(Integer.parseInt(idBuscarDetalle.getText().toString()));

                call.enqueue(new Callback<List<DetalleProductoPedido>>() {
                    @Override
                    public void onResponse(Call<List<DetalleProductoPedido>> call, Response<List<DetalleProductoPedido>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Detalle Eliminado",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<List<DetalleProductoPedido>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return vista;
    }
}
