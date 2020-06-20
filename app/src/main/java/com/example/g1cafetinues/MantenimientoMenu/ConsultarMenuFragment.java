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
import com.example.g1cafetinues.clases.Menu;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsultarMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultarMenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText id;
    EditText idconsulta;
    EditText precio;
    EditText fechaini;
    EditText fechafin;
    Button aceptar;
    Retrofit retrofit;
    public ConsultarMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultarMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultarMenuFragment newInstance(String param1, String param2) {
        ConsultarMenuFragment fragment = new ConsultarMenuFragment();
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
        View vista=inflater.inflate(R.layout.fragment_consultar_menu, container, false);
        idconsulta=vista.findViewById(R.id.editConsultamenu);
        id=vista.findViewById(R.id.mostraridmenu);
        precio=vista.findViewById(R.id.mostrarmenu);
        fechaini=vista.findViewById(R.id.mostrarfechainicio);
        fechafin=vista.findViewById(R.id.mostrarfechafin);
        aceptar=vista.findViewById(R.id.botonConsultarmenu);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiServices service = retrofit.create(ApiServices.class);


                service.ObtenerMenu(idconsulta.getText().toString()).
                        enqueue(new Callback<Menu>() {
                            @Override
                            public void onResponse(Call<Menu> call, Response<Menu> response) {
                                if(response.isSuccessful()){
                                    Menu respuesta=response.body();
                                    id.setText(respuesta.getIDMENU().toString());
                                    precio.setText(respuesta.getPRECIOMENU().toString());
                                    fechaini.setText(respuesta.getFECHADESDEMENU().toString());
                                    fechafin.setText(respuesta.getFECHAHASTAMENU().toString());
                                }else{
                                    Toast.makeText(getActivity(), "no valido", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Menu> call, Throwable t) {
                                Toast.makeText(getActivity(), "fallo ws", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
        return vista;
    }
}