package com.example.g1cafetinues.MantenimientoPedido;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.Pedido;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText idpedido;
    EditText mostrarid;
    EditText mostrarestado;
    EditText mostrarnombre;
    EditText mostrarfecha;
    Retrofit retrofit;
    Button aceptar;
    Button limpiar;

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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.UrlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        View vista=inflater.inflate(R.layout.fragment_consultar_pedido, container, false);
        idpedido=vista.findViewById(R.id.editConsultaIdPedido);
        mostrarestado=vista.findViewById(R.id.mostratestado);
        mostrarfecha=vista.findViewById(R.id.mostrarfecha);
        mostrarid=vista.findViewById(R.id.mostraridpedido);
        mostrarnombre=vista.findViewById(R.id.mostrarnombre);
        aceptar=vista.findViewById(R.id.botonConsultarpedido);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiServices service = retrofit.create(ApiServices.class);


                service.ObtenerPedido(idpedido.getText().toString()).
                        enqueue(new Callback<Pedido>() {
                            @Override
                            public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                            if(response.isSuccessful()){
                                Pedido Respuesta=response.body();
                                mostrarestado.setText(Respuesta.getIDESTADOPEDIDO());
                                mostrarfecha.setText(Respuesta.getFECHAPEDIDO());
                                mostrarid.setText(Respuesta.getIDPEDIDO());
                                mostrarnombre.setText(Respuesta.getCLIENTE());
                            }else{
                                Toast.makeText(getActivity(), "revise los datos", Toast.LENGTH_SHORT).show();
                            }
                            }

                            @Override
                            public void onFailure(Call<Pedido> call, Throwable t) {
                                Toast.makeText(getActivity(), "Fallo WS", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
        return vista;
    }
}
