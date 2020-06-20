package com.example.g1cafetinues.MantenimientoProductos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.ProductoApi;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultaProductosFragment extends Fragment {
    EditText idconsultar;
    EditText mostrarid;
    EditText mostrarcategoria;
    EditText mostrarnombre;
    EditText mostrarprecio;
    EditText mostrarExistencia;
    Button consultar;
    Button limpiar;
    Retrofit retrofit;


    public ConsultaProductosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.UrlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_consulta_productos, container, false);
        idconsultar=vista.findViewById(R.id.editConsultaIdProducto);
        mostrarid=vista.findViewById(R.id.mostraridproducto);
        mostrarcategoria=vista.findViewById(R.id.mostratCategoria);
        mostrarnombre=vista.findViewById(R.id.mostrarnombre);
        mostrarprecio=vista.findViewById(R.id.mostrarprecio);
        mostrarExistencia=vista.findViewById(R.id.mostrarexistencia);
        consultar=vista.findViewById(R.id.botonConsultarproducto);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=idconsultar.getText().toString();
                ApiServices service = retrofit.create(ApiServices.class);


                service.ConsultarProducto(id).
                        enqueue(new Callback<ProductoApi>() {
                            @Override
                            public void onResponse(Call<ProductoApi> call, Response<ProductoApi> response) {
                                if(response.isSuccessful()){

                                    ProductoApi respuesta=response.body();
                                    mostrarid.setText(respuesta.getIDPRODUCTO().toString());
                                    mostrarcategoria.setText(respuesta.getIDCATEGORIA().toString());
                                    mostrarnombre.setText(respuesta.getNOMBREPRODUCTO().toString());
                                    mostrarprecio.setText(respuesta.getPRECIOUNITARIO().toString());
                                    mostrarExistencia.setText(respuesta.getEXISTENCIA().toString());
                                }else{
                                //    Toast.makeText(requireActivity(),"no tiene este producto",Toast.LENGTH_LONG).show();
                                }

                            }

                            @Override
                            public void onFailure(Call<ProductoApi> call, Throwable t) {
                              //  Toast.makeText(requireActivity(),"fallo ws",Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
        return vista;
    }
}
