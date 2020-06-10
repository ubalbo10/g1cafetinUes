package com.example.g1cafetinues;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.g1cafetinues.Adaptadores.AdaptorLocales;
import com.example.g1cafetinues.clases.Local;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeClienteFragment extends Fragment {
    Button btn_regresar;
    RecyclerView recycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Retrofit retrofit;

    //simulando el arraylist
    List<Local> locales=new ArrayList<Local>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.UrlBase)
                 .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ApiServices service = retrofit.create(ApiServices.class);
        // Inflate the layout for this fragment
        //RECYCLER //
        View vista=inflater.inflate(R.layout.fragment_home_cliente, container, false);
        //llamar recyclerview//
        recycler=vista.findViewById(R.id.Recycler_locales);

        //FIN DE RECYCLER//

        /* datos quemados */
//        String restaurante1="restaurante1";
//        String restaurante2="restaurante2";
//        String restaurante3="restaurante3";
//        String restaurante4="restaurante4";
//        String restaurante5="restaurante5";
//        locales.add(restaurante1);
//        locales.add(restaurante2);
//        locales.add(restaurante3);
//        locales.add(restaurante4);
//        locales.add(restaurante5);
           Call<List<Local>> local=service.ObtenerLocales();
           local.enqueue(new Callback<List<Local>>() {
               @Override
               public void onResponse(Call<List<Local>> call, Response<List<Local>> response) {
                   if(response.isSuccessful()){
                       locales=response.body();
                       recycler.setHasFixedSize(true);
                       //layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);;
                       layoutManager=new GridLayoutManager(getActivity(),2);
                       recycler.setLayoutManager(layoutManager);
                       mAdapter=new AdaptorLocales(locales);
                       recycler.setAdapter(mAdapter);

                   }
               }

               @Override
               public void onFailure(Call<List<Local>> call, Throwable t) {
                   Toast.makeText(getActivity(),"Falló servidor",Toast.LENGTH_LONG).show();
                   Log.i("falloWS",t.getMessage().toString());
                   Log.i("falloWStodo",t.getMessage().toString());

               }
           });


         /* fin */


        return vista;
    }
}
