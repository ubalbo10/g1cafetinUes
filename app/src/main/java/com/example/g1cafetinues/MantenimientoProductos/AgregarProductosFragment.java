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
public class AgregarProductosFragment extends Fragment {
    EditText idproducto;
    EditText idcategoria;
    EditText idlocal;
    EditText nombre;
    EditText precio;
    EditText cantidad;
    Button aceptar;
    Button limpiar;
    Retrofit retrofit;

    public AgregarProductosFragment() {
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
        View vista=inflater.inflate(R.layout.fragment_agregar_productos, container, false);
        idproducto=vista.findViewById(R.id.editidproducto);
        idcategoria=vista.findViewById(R.id.editidcategoria);
        idlocal=vista.findViewById(R.id.editIdlocal);
        nombre=vista.findViewById(R.id.editNombreproducto);
        precio=vista.findViewById(R.id.editPrecioUnitario);
        cantidad=vista.findViewById(R.id.editMCantidadProducto);
        aceptar=vista.findViewById(R.id.button_aceptar_agregar);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_producto=idproducto.getText().toString();
                String id_categoria=idcategoria.getText().toString();
                String id_local=idlocal.getText().toString();
                String nombre_producto=nombre.getText().toString();
                String precio_producto=precio.getText().toString();
                String cantidad_producto=cantidad.getText().toString();
                ApiServices service = retrofit.create(ApiServices.class);
                service.RegistrarProducto(id_producto,id_local,id_categoria,nombre_producto,precio_producto,cantidad_producto,"20").
                        enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                             if(response.isSuccessful()){
                                 String respuesta=response.body();
                                 if(respuesta=="1"){
                                     Toast.makeText(requireActivity(),"producto agregado",Toast.LENGTH_LONG).show();
                                 }else{
                                     Toast.makeText(requireActivity(),"producto no agregado",Toast.LENGTH_LONG).show();
                                 }
                             }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(requireActivity(),"fallo ws",Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
        return vista;
    }
}
