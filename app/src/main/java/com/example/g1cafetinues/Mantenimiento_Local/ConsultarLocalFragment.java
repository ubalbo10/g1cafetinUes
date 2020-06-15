package com.example.g1cafetinues.Mantenimiento_Local;

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
import com.example.g1cafetinues.clases.TLocal;
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
 * Use the {@link ConsultarLocalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultarLocalFragment extends Fragment {

    public ConsultarLocalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_consultar_local, container, false);

        Button buscar=vista.findViewById(R.id.btn_buscarLocal);

        final EditText idBuscarLocal=vista.findViewById(R.id.editText_buscarIdLocal);
        final TextView idLocal=vista.findViewById(R.id.textView_buscarIdLocal);
        final TextView idEncaragado=vista.findViewById(R.id.textView_buscarIdEncargado);
        final TextView nombreLocal=vista.findViewById(R.id.textView_buscarNombreLocal);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(UrlApi.UrlBase)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ApiServices apiServices=retrofit.create(ApiServices.class);

                Call<List<TLocal>> call=apiServices.obtenerLocal(Integer.parseInt(idBuscarLocal.getText().toString()));

                call.enqueue(new Callback<List<TLocal>>() {
                    @Override
                    public void onResponse(Call<List<TLocal>> call, Response<List<TLocal>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                            Log.d("ERROR", "onResponse: "+response.code());
                            return;
                        }

                        List<TLocal> locales=response.body();
                        idLocal.setText(locales.get(0).getIDLOCAL().toString());
                        idEncaragado.setText(locales.get(0).getIDENCARGADO().toString());
                        nombreLocal.setText(locales.get(0).getNOMBRELOCAL());
                    }

                    @Override
                    public void onFailure(Call<List<TLocal>> call, Throwable t) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return inflater.inflate(R.layout.fragment_consultar_local, container, false);
    }
}
