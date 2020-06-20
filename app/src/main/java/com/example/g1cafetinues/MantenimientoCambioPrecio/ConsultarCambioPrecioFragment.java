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
import com.example.g1cafetinues.clases.CambioPrecio;
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
public class ConsultarCambioPrecioFragment extends Fragment {

    public ConsultarCambioPrecioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista =inflater.inflate(R.layout.fragment_consultar_cambio_precio, container, false);

        Button buscar=vista.findViewById(R.id.btn_buscarCambioPrecio);

        final EditText idBuscarCambioPrecio=vista.findViewById(R.id.editText_buscarIdCambioPrecio);

        final TextView idCambioPrecio=vista.findViewById(R.id.textView_buscarIdCambioPrecio);
        final TextView idProducto=vista.findViewById(R.id.textView_buscarIdProducto);
        final TextView fechaCambio=vista.findViewById(R.id.textView_buscarFechaCambio);
        final TextView precioNuevo=vista.findViewById(R.id.textView_buscarPrecioNuevo);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<List<CambioPrecio>> call=apiServices.obtenerCambioPrecio(Integer.parseInt(idBuscarCambioPrecio.getText().toString()));

                call.enqueue(new Callback<List<CambioPrecio>>() {
                    @Override
                    public void onResponse(Call<List<CambioPrecio>> call, Response<List<CambioPrecio>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error response",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<CambioPrecio> cambioPrecios=response.body();
                        idCambioPrecio.setText(cambioPrecios.get(0).getIDCAMBIOPRECIO().toString());
                        idProducto.setText(cambioPrecios.get(0).getIDPRODUCTO().toString());
                        fechaCambio.setText(cambioPrecios.get(0).getFECHACAMBIO());
                        precioNuevo.setText(cambioPrecios.get(0).getPRECIONUEVO().toString());
                    }

                    @Override
                    public void onFailure(Call<List<CambioPrecio>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error failure",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return vista;
    }
}
