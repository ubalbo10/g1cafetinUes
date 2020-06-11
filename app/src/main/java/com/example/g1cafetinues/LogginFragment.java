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
import com.example.g1cafetinues.clases.Usuario;
import com.example.g1cafetinues.interfaces.ApiServices;
import com.example.g1cafetinues.interfaces.DatosUsuarioActivo;
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



        View vista=inflater.inflate(R.layout.fragment_loggin, container, false);
        btn_ingresar=vista.findViewById(R.id.Ingresar);
        btn_cerrar=vista.findViewById(R.id.Loggin_Salir);
        usuario=vista.findViewById(R.id.editText_User);
        pass=vista.findViewById(R.id.editText_pass);

        String user=usuario.getText().toString();
        String contra=pass.getText().toString();


        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                //Toast.makeText(getActivity(), "boton presionado", Toast.LENGTH_SHORT).show();
                //Log.i("texto","si me ejecuto");
                String user=usuario.getText().toString();
                String contra=pass.getText().toString();
                ApiServices service = retrofit.create(ApiServices.class);

                Call<Usuario> login= service.ObtenerLogin(user,contra);
                login.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.isSuccessful()){
                            if(response.body().toString().isEmpty()){
                             Toast.makeText(getActivity(),"usuario no registarado",Toast.LENGTH_LONG).show();
                            }else {
                                Usuario respuesta = response.body();
                                //datos del usuario
                                DatosUsuarioActivo.activo = 1;
                                DatosUsuarioActivo.nombre = respuesta.getNOMUSUARIO();
                                DatosUsuarioActivo.idtipo = respuesta.getIDTIPOUSUARIO().toString();
                                DatosUsuarioActivo.idusuario = respuesta.getIDUSUARIO();
                                Log.i("datos", DatosUsuarioActivo.nombre);
                                Toast.makeText(getActivity(), "ingreso correcto", Toast.LENGTH_LONG).show();
                                Toast.makeText(getActivity(), DatosUsuarioActivo.nombre, Toast.LENGTH_LONG).show();
                                findNavController(v).navigate(R.id.irahome);
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getActivity(),"fallo de ws",Toast.LENGTH_LONG).show();
                    }
                });
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
