package com.example.g1cafetinues.MantenimientoMenu;

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
 * Use the {@link AddMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddMenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText id;
    EditText precio;
    EditText fechaini;
    EditText fechafin;
    Button aceptar;
    Button limpiar;
    Retrofit retrofit;

    public AddMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddMenuFragment newInstance(String param1, String param2) {
        AddMenuFragment fragment = new AddMenuFragment();
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

        View vista=inflater.inflate(R.layout.fragment_add_menu, container, false);
        id=vista.findViewById(R.id.editidmenu);
        precio=vista.findViewById(R.id.editpreciomenu);
        fechaini=vista.findViewById(R.id.editfechaini);
        fechafin=vista.findViewById(R.id.editfechafin);
        aceptar=vista.findViewById(R.id.button_aceptar_agregarmenu);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiServices service = retrofit.create(ApiServices.class);
                String idmenu=id.getText().toString();
                String preciomenu=precio.getText().toString();
                String fechainicio=fechaini.getText().toString();
                String fechafinal=fechafin.getText().toString();


                service.AgregarMenu(idmenu,preciomenu,fechainicio,fechafinal).
                        enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if (response.isSuccessful()){
                                    String respuesta=response.body();
                                    if(respuesta=="1"){
                                        Toast.makeText(requireActivity(), "menu agregado", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(requireActivity(), "No agregado", Toast.LENGTH_SHORT).show();
                                    }
                                }else {
                                    Toast.makeText(requireActivity(), "No agregado", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(requireActivity(), "fallo ws", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
        return vista;
    }
}