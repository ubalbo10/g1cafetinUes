package com.example.g1cafetinues.detalle_producto_pedido;

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
public class AgregarDetalleProductoPedidoFragment extends Fragment {

    public AgregarDetalleProductoPedidoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_agregar_detalle_producto_pedido, container, false);

        Button aceptar=vista.findViewById(R.id.btn_agregarAceptar);

        final TextView cantidad=vista.findViewById(R.id.editText_cantidad);
        final TextView idDetalle=vista.findViewById(R.id.editText_idDetalle);
        final TextView idPedido=vista.findViewById(R.id.editText_idPedido);
        final TextView idProducto=vista.findViewById(R.id.editText_idProducto);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                DetalleProductoPedido detalle=new DetalleProductoPedido();
                detalle.setCANTIDADPEDIDO(Integer.parseInt(cantidad.getText().toString()));
                detalle.setIDDETALLE(Integer.parseInt(idDetalle.getText().toString()));
                detalle.setIDPEDIDO(Integer.parseInt(idPedido.getText().toString()));
                detalle.setIDPRODUCTO(Integer.parseInt(idProducto.getText().toString()));

                Call<DetalleProductoPedido> call=apiServices.agregarDetalleProductoPedido(detalle);

                call.enqueue(new Callback<DetalleProductoPedido>() {
                    @Override
                    public void onResponse(Call<DetalleProductoPedido> call, Response<DetalleProductoPedido> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Detalle Agregado",Toast.LENGTH_LONG).show();
                        cantidad.setText("");
                        idDetalle.setText("");
                        idPedido.setText("");
                        idProducto.setText("");
                    }

                    @Override
                    public void onFailure(Call<DetalleProductoPedido> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return vista;
    }
}
