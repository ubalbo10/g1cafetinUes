package com.example.g1cafetinues;

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

import com.example.g1cafetinues.clases.Pedido;
import com.example.g1cafetinues.interfaces.ApiServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsultarPedidoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultarPedidoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Retrofit retrofit;
    ApiServices api;

    View vista;
    EditText etPedido;
    TextView tvTitulo,tvClienteR;
    Button btnConsultar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConsultarPedidoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultarPedidoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultarPedidoFragment newInstance(String param1, String param2) {
        ConsultarPedidoFragment fragment = new ConsultarPedidoFragment();
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
/*
            etPedido = (EditText) etPedido.findViewById(R.id.etPedido);
            tvTitulo = (TextView) tvTitulo.findViewById(R.id.tvTitulo);
            tvClienteR = (TextView) tvTitulo.findViewById(R.id.tvClienteR);
            btnConsultar = (Button) btnConsultar.findViewById(R.id.btnConsultar);

            retrofit = new AdaptadorPedidos().getAdaptador();
            api = retrofit.create(ApiServices.class);
*/

        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_consultar_pedido, container, false);
        Button buscar=vista.findViewById(R.id.btnConsultar);

        // final EditText idBuscarDetalle=vista.findViewById(R.id.editText_buscarIdDetalle);

        final EditText etPedido = vista.findViewById(R.id.etPedido);
        final TextView tvRutaR = vista.findViewById(R.id.tvRutaR);
        final TextView tvEstadoR= vista.findViewById(R.id.tvEstadoR);
        final TextView tvTrabajadorR = vista.findViewById(R.id.tvTrabajadorR);
        final TextView tvRepartidorR = vista.findViewById(R.id.tvRepartidorR);
        final TextView tvUbicacionR = vista.findViewById(R.id.tvUbicacionR);
        final TextView tvFechaR = vista.findViewById(R.id.tvFechaR);
        final TextView tvClienteR = vista.findViewById(R.id.tvClienteR);
        final TextView tvLlevarR = vista.findViewById(R.id.tvLlevarR);


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl("https://3.133.138.215:5000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<List<Pedido>> call=apiServices.ObtenerPedidos(Integer.parseInt(etPedido.getText().toString()));

                call.enqueue(new Callback<List<Pedido>>() {
                    @Override
                    public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<Pedido> listaPedido=response.body();
                        tvRutaR.setText(String.valueOf(listaPedido.get(0).getIDRUTA()));
                        tvEstadoR.setText(String.valueOf(listaPedido.get(0).getIDESTADOPEDIDO()));
                        tvTrabajadorR.setText(String.valueOf(listaPedido.get(0).getIDTRABAJADOR()));
                        tvRepartidorR.setText(String.valueOf(listaPedido.get(0).getIDREPARTIDOR()));
                        tvUbicacionR.setText(String.valueOf(listaPedido.get(0).getIDUBICACION()));
                        tvFechaR.setText(String.valueOf(listaPedido.get(0).getFECHAPEDIDO()));
                        tvClienteR.setText(String.valueOf(listaPedido.get(0).getCLIENTE()));
                        tvLlevarR.setText(String.valueOf(listaPedido.get(0).getPARALLEVAR()));
                    }

                    @Override
                    public void onFailure(Call<List<Pedido>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        return vista;
    }
}
