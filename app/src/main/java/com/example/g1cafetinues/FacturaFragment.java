package com.example.g1cafetinues;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.g1cafetinues.Adaptadores.AdaptadorFactura;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.DatosFactura;
import com.example.g1cafetinues.interfaces.Factura;
import com.example.g1cafetinues.interfaces.Facturas;
import com.example.g1cafetinues.interfaces.UrlApi;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FacturaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FacturaFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recycler;
    TextView totalfactura;
    EditText nombre;
    EditText idubicacion;
    RadioButton si;
    EditText idfactura;
    RadioButton no;
    Button aceptar;
    Button cancelar;
    Retrofit retrofit;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public FacturaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FacturaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FacturaFragment newInstance(String param1, String param2) {
        FacturaFragment fragment = new FacturaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.UrlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Integer tamano=Facturas.detalleFactura.size();
        // Inflate the layout for this fragment
        Toast.makeText(getActivity(), tamano.toString(),Toast.LENGTH_LONG).show();
        View vista=inflater.inflate(R.layout.fragment_factura, container, false);
        nombre=vista.findViewById(R.id.edit_setNombrecliente);
        idubicacion=vista.findViewById(R.id.edit_ubicacion);
        si=vista.findViewById(R.id.llevarCierto);
        no=vista.findViewById(R.id.llevarFalso);
        idfactura=vista.findViewById(R.id.editidfactura);
        recycler=vista.findViewById(R.id.recycler_factura);
        recycler.setHasFixedSize(true);
        //grip es para poder ponerle columnas
        layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        //layoutManager = new GridLayoutManager(getActivity(),1);
        recycler.setLayoutManager(layoutManager);
        mAdapter=new AdaptadorFactura(Facturas.detalleFactura);
        recycler.setAdapter(mAdapter);

        totalfactura=vista.findViewById(R.id.factura_total_pagar);
        aceptar=vista.findViewById(R.id.button_fac_aceptar);
        cancelar=vista.findViewById(R.id.button_fac_cancelar);
        Float sumaTotalFactura=0f;
        for (int i=0;i<Facturas.detalleFactura.size();i++) {
            sumaTotalFactura=sumaTotalFactura + Facturas.detalleFactura.get(i).getTotal();

        }
        totalfactura.setText(sumaTotalFactura.toString());
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             // aqui debemos de guardar la factura
                String llevar="no";
                String ubicacion="0";
                if(si.isChecked()){
                    llevar="si";
                    ubicacion=idubicacion.getText().toString();
                }else{
                    llevar="no";
                    ubicacion="0";
                }
                java.util.Date fecha = new Date();
                String fechaact=fecha.toString();


                ApiServices service = retrofit.create(ApiServices.class);

                service.GuardarPedido(idfactura.getText().toString(),llevar,ubicacion,fechaact,nombre.getText().toString(), Facturas.detalleFactura).
                        enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {
                                        if(response.isSuccessful()){
                                            String respuesta=response.body();
                                            if(respuesta=="1"){
                                                Toast.makeText(requireActivity(), "Factura guardada", Toast.LENGTH_SHORT).show();
                                            }else{
                                                Toast.makeText(requireActivity(), "Factura No guardada", Toast.LENGTH_SHORT).show();
                                            }
                                        }else {
                                            Toast.makeText(requireActivity(), "Factura No guardada", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {
                                        Toast.makeText(requireActivity(), "Factura No guardada fallo ws", Toast.LENGTH_SHORT).show();
                                    }
                                });


               // Toast.makeText(getActivity(), "Pedido guardado con exito", Toast.LENGTH_SHORT).show();
                findNavController(v).navigate(R.id.action_facturaFragment_to_homeClienteFragment);

            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Pedido cancelado", Toast.LENGTH_SHORT).show();
                findNavController(v).navigate(R.id.action_facturaFragment_to_homeClienteFragment);

            }
        });

        return vista;
    }

}
