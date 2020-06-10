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
 * Use the {@link ActualizarDetalleProductoPedidoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActualizarDetalleProductoPedidoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ActualizarDetalleProductoPedidoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActualizarDetalleProductoPedidoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActualizarDetalleProductoPedidoFragment newInstance(String param1, String param2) {
        ActualizarDetalleProductoPedidoFragment fragment = new ActualizarDetalleProductoPedidoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_actualizar_detalle_producto_pedido, container, false);

        Button buscar=vista.findViewById(R.id.btn_buscarPedido);
        Button actualizar=vista.findViewById(R.id.btn_actualizarAceptar);

        final EditText idBuscarDetalle=vista.findViewById(R.id.editText_buscarIdDetalle);
        final TextView cantidad=vista.findViewById(R.id.editText_actulizarCantidad);
        final TextView idDetalle=vista.findViewById(R.id.editText_actualizarIdDetalle);
        final TextView idPedido=vista.findViewById(R.id.editText_actualizarIdPedido);
        final TextView idProducto=vista.findViewById(R.id.editText_actualizarIdProducto);

        actualizar.setOnClickListener(new View.OnClickListener() {
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

                Call<DetalleProductoPedido> call=apiServices.actualizarDetalleProductoPedido(detalle);

                call.enqueue(new Callback<DetalleProductoPedido>() {
                    @Override
                    public void onResponse(Call<DetalleProductoPedido> call, Response<DetalleProductoPedido> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        Toast.makeText(getContext(),"Detalle Actualizado",Toast.LENGTH_LONG).show();
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

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<List<DetalleProductoPedido>> call=apiServices.obtenerDetalleProductoPedido(Integer.parseInt(idBuscarDetalle.getText().toString()));

                call.enqueue(new Callback<List<DetalleProductoPedido>>() {
                    @Override
                    public void onResponse(Call<List<DetalleProductoPedido>> call, Response<List<DetalleProductoPedido>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<DetalleProductoPedido> listaDetalle=response.body();
                        cantidad.setText(listaDetalle.get(0).getCANTIDADPEDIDO().toString());
                        idDetalle.setText(listaDetalle.get(0).getIDDETALLE().toString());
                        idPedido.setText(listaDetalle.get(0).getIDPEDIDO().toString());
                        idProducto.setText(listaDetalle.get(0).getIDPRODUCTO().toString());
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
