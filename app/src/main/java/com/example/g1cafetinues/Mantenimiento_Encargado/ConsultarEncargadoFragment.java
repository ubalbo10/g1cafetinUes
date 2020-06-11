package com.example.g1cafetinues.Mantenimiento_Encargado;

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
import com.example.g1cafetinues.clases.Encargado;
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
 * Use the {@link ConsultarEncargadoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultarEncargadoFragment extends Fragment {

    public ConsultarEncargadoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_consultar_encargado, container, false);

        Button buscar=vista.findViewById(R.id.btn_buscarEncargdo);

        final EditText idBuscarEncargado=vista.findViewById(R.id.editText_buscarIdEncargado);
        final TextView idEncargado=vista.findViewById(R.id.textView_buscarIdEncargado);
        final TextView nombre=vista.findViewById(R.id.textView_buscarNombre);
        final TextView apellido=vista.findViewById(R.id.textView_buscarapellido);
        final TextView telefono=vista.findViewById(R.id.textView_buscarTelefono);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<List<Encargado>> call=apiServices.obtenerEncargado(Integer.parseInt(idBuscarEncargado.getText().toString()));

                call.enqueue(new Callback<List<Encargado>>() {
                    @Override
                    public void onResponse(Call<List<Encargado>> call, Response<List<Encargado>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<Encargado> listaEncargado=response.body();
                        idEncargado.setText(Integer.parseInt(listaEncargado.get(0).getIDENCARGADO().toString()));
                        nombre.setText(listaEncargado.get(0).getNOMBRE().toString());
                        apellido.setText(listaEncargado.get(0).getAPELLIDO().toString());
                        telefono.setText(Integer.parseInt(listaEncargado.get(0).getTELEFONO().toString()));
                    }

                    @Override
                    public void onFailure(Call<List<Encargado>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        return vista;
    }
}
