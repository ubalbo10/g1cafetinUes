package com.example.g1cafetinues;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.g1cafetinues.clases.Trabajador;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.UrlApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogginFragment extends Fragment {
    Button btn_ingresar;
    Button btn_cerrar;
    EditText usuario;
    EditText pass;
    Retrofit retrofit;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.UrlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServices service = retrofit.create(ApiServices.class);


        View vista=inflater.inflate(R.layout.fragment_loggin, container, false);
        btn_ingresar=vista.findViewById(R.id.Ingresar);
        btn_cerrar=vista.findViewById(R.id.Loggin_Salir);
        usuario=vista.findViewById(R.id.editText_User);
        pass=vista.findViewById(R.id.editText_pass);

        String user=usuario.getText().toString();
        String contra=pass.getText().toString();

        Call<Trabajador> login= service.ObtenerLogin(user,contra);
        login.enqueue(new Callback<Trabajador>() {
            @Override
            public void onResponse(Call<Trabajador> call, Response<Trabajador> response) {
                if(response.isSuccessful()){
                    Trabajador respuesta= response.body();
                    //crear una clase que guarde los datos del login para poder usar esos datos mas adelantes
                    
                }
            }

            @Override
            public void onFailure(Call<Trabajador> call, Throwable t) {

            }
        });
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.irahome);
                Toast.makeText(getActivity(), "boton presionado", Toast.LENGTH_SHORT).show();
                Log.i("texto","si me ejecuto");
            }
        });
        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //salir de  la app
                getActivity().finish();
            }
        });

        return vista;
    }
}
