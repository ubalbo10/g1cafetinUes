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
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateCategoriaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateCategoriaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText id;
    EditText nombre;
    Button aceptar;
    Button limpiar;
    Retrofit retrofit;
    public UpdateCategoriaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateCategoriaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateCategoriaFragment newInstance(String param1, String param2) {
        UpdateCategoriaFragment fragment = new UpdateCategoriaFragment();
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
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.UrlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_update_categoria, container, false);
        id=vista.findViewById(R.id.editUpdateidcategoria);
        nombre=vista.findViewById(R.id.editupdatenombrecategoria);
        aceptar=vista.findViewById(R.id.button_aceptar_agregarCategoriaUpdate);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiServices service = retrofit.create(ApiServices.class);


                service.ActualizarCategoria(id.getText().toString(),nombre.getText().toString()).
                        enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                               if(response.isSuccessful()){
                                String respuesta=response.body();
                                if(respuesta=="1"){
                                    Toast.makeText(requireActivity(), "Categoria actualizada", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(requireActivity(), "No actualizada", Toast.LENGTH_SHORT).show();
                                }
                               }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(requireActivity(), "Error ws", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
        return vista;
    }
}
