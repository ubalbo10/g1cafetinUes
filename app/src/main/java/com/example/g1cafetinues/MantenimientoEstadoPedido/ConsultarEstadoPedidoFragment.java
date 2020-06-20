package com.example.g1cafetinues.MantenimientoEstadoPedido;

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
import com.example.g1cafetinues.clases.EstadoPedido;
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
public class ConsultarEstadoPedidoFragment extends Fragment {

    public ConsultarEstadoPedidoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_consultar_estado_pedido, container, false);

        Button buscar=vista.findViewById(R.id.btn_buscarEstadoPedido);

        final EditText idBuscarEstadoPedido=vista.findViewById(R.id.editText_buscarIdEstadoPedido);
        final TextView idEstadoPedido=vista.findViewById(R.id.textView_buscarIdEstadoPedido);
        final TextView descEstadoPedido=vista.findViewById(R.id.textView_buscarDescEstadoPedido);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<List<EstadoPedido>> call=apiServices.obtenerEstadoPedido(Integer.parseInt(idBuscarEstadoPedido.getText().toString()));

                call.enqueue(new Callback<List<EstadoPedido>>() {
                    @Override
                    public void onResponse(Call<List<EstadoPedido>> call, Response<List<EstadoPedido>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<EstadoPedido> estadoPedidos=response.body();
                        idEstadoPedido.setText(estadoPedidos.get(0).getIDESTADOPEDIDO().toString());
                        descEstadoPedido.setText(estadoPedidos.get(0).getDESCESTADOPEDIDO().toString());
                    }

                    @Override
                    public void onFailure(Call<List<EstadoPedido>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return vista;
    }
}
