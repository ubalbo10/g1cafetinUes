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
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdatePedidoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdatePedidoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText idpedido;
    EditText idruta;
    EditText idestado;
    EditText idtrabajador;
    EditText idrepartidor;
    EditText idubicacion;
    EditText cliente;
    EditText parallevar;
    Button aceptar;
    Button limpiar;
    Retrofit retrofit;


    public UpdatePedidoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdatePedidoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdatePedidoFragment newInstance(String param1, String param2) {
        UpdatePedidoFragment fragment = new UpdatePedidoFragment();
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

        View vista=inflater.inflate(R.layout.fragment_update_pedido, container, false);
        idpedido=vista.findViewById(R.id.editidpedido);
        idubicacion=vista.findViewById(R.id.editIdUbicacion);
        idestado=vista.findViewById(R.id.editIdestado);
        idrepartidor=vista.findViewById(R.id.editidrepartirdor);
        idtrabajador=vista.findViewById(R.id.editidtrabajadorcrearpedido);
        cliente=vista.findViewById(R.id.editclientepedido);
        parallevar=vista.findViewById(R.id.editllevar);
        aceptar=vista.findViewById(R.id.button_aceptar_agregar);
        java.util.Date fecha = new Date();
        final String fechaa=fecha.toString();
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiServices service = retrofit.create(ApiServices.class);
                service.ActualizarPedido(idpedido.getText().toString(),
                        idruta.getText().toString(), Integer.valueOf(idestado.getText().toString()),
                        idtrabajador.getText().toString(),idrepartidor.getText().toString(),
                        idubicacion.getText().toString(),fechaa,cliente.getText().toString(),Integer.parseInt(parallevar.getText().toString())).
                        enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if(response.isSuccessful()){
                                    String respuesta=response.body();
                                    if(respuesta=="1"){
                                        Toast.makeText(requireActivity(), "pedido guardado", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(requireActivity(), "No guardado", Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(requireActivity(), "No guardado", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(requireActivity(), "problema en el ws", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
        return vista;
    }
}
