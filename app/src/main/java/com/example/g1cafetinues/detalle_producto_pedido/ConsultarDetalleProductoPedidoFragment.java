package com.example.g1cafetinues.detalle_producto_pedido;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
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
 * Use the {@link ConsultarDetalleProductoPedidoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultarDetalleProductoPedidoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConsultarDetalleProductoPedidoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultarDetalleProductoPedidoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultarDetalleProductoPedidoFragment newInstance(String param1, String param2) {
        ConsultarDetalleProductoPedidoFragment fragment = new ConsultarDetalleProductoPedidoFragment();
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
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_consultar_detalle_producto_pedido, container, false);
            Button buscar=vista.findViewById(R.id.btn_buscarDetalle);

        final EditText idBuscarDetalle=vista.findViewById(R.id.editText_buscarIdDetalle);
        final TextView cantidad=vista.findViewById(R.id.textView_consultarCantidad);
        final TextView idDetalle=vista.findViewById(R.id.textView_consultarIdDetalle);
        final TextView idPedido=vista.findViewById(R.id.textView_consultarIdPedido);
        final TextView idProducto=vista.findViewById(R.id.textView_consultarIProducto);

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
