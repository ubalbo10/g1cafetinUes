package com.example.g1cafetinues.ui.MantenimientoRepartidor;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.g1cafetinues.Adaptadores.AdaptorRepartidores;
import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.Repartidor;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static androidx.navigation.Navigation.findNavController;

public class ObtenerRepartidorFragment extends Fragment {
    private com.example.g1cafetinues.interfaces.ApiServices apiServices;
    Button btn_regresar;
    RecyclerView recycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Retrofit retrofit;

    //simulando el arraylist
    List<Repartidor> repartidores=new ArrayList<Repartidor>();

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        //super.onCreate(savedInstanceState);
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.UrlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    //Obtener Repartidores
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ApiServices service = retrofit.create(ApiServices.class);
        // Inflate the layout for this fragment
        //RECYCLER //
        View vista=inflater.inflate(R.layout.fragment_obtener_repartidor, container, false);
        //llamar recyclerview//
        recycler=vista.findViewById(R.id.ObtenerRepartidor);
        //FIN DE RECYCLER//

        Call<List<Repartidor>> repartidor = service.ObtenerRepartidores();
        repartidor.enqueue(new Callback<List<Repartidor>>() {
            @Override
            public void onResponse(Call<List<Repartidor>> call, Response<List<Repartidor>> response) {
                if(response.isSuccessful()){
                    repartidores=response.body();
                    recycler.setHasFixedSize(true);
                    //layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);;
                    layoutManager=new GridLayoutManager(getActivity(),2);
                    recycler.setLayoutManager(layoutManager);
                    mAdapter=new AdaptorRepartidores(repartidores);
                    recycler.setAdapter(mAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<Repartidor>> call, Throwable t) {
                Toast.makeText(getActivity(),"Falló servidor",Toast.LENGTH_LONG).show();
                Log.i("falloWS",t.getMessage().toString());
                Log.i("falloWStodo",t.getMessage().toString());

            }
        });



        return vista;
    }

}
