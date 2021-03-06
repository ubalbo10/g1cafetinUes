package com.example.g1cafetinues.MantenimientoCategorias;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.Categoria;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsultarCategoriaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultarCategoriaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText idconsultar;
    EditText mostrarid;
    EditText mostrarnombre;
    Button consultar;
    Button limpiar;
    Retrofit retrofit;

    public ConsultarCategoriaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultarCategoriaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultarCategoriaFragment newInstance(String param1, String param2) {
        ConsultarCategoriaFragment fragment = new ConsultarCategoriaFragment();
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
        View vista=inflater.inflate(R.layout.fragment_consultar_categoria, container, false);
        idconsultar=vista.findViewById(R.id.editConsultaIdCategoria);
        mostrarid=vista.findViewById(R.id.mostraridcategoria);
        mostrarnombre=vista.findViewById(R.id.mostraNombreCategoria);
        consultar=vista.findViewById(R.id.botonConsultarcategoria);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiServices service = retrofit.create(ApiServices.class);


                service.ObtenerCategoria(idconsultar.getText().toString()).
                        enqueue(new Callback<Categoria>() {
                            @Override
                            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                            if(response.isSuccessful()){
                              Categoria respuesta=response.body();
                              mostrarid.setText(respuesta.getIDCATEGORIA().toString());
                              mostrarnombre.setText(respuesta.getNOMBRECATEGORIA().toString());
                                Toast.makeText(getActivity(),"exito",Toast.LENGTH_LONG).show();
                             }else {
                                Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
                            }
                            }

                            @Override
                            public void onFailure(Call<Categoria> call, Throwable t) {
                                Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
                            }
                        });

            }
        });
        return vista;
    }
}
