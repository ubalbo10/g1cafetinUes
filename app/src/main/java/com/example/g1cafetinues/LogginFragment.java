package com.example.g1cafetinues;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogginFragment extends Fragment {
    Button btn_ingresar;
    Button btn_cerrar;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_loggin, container, false);
        btn_ingresar=vista.findViewById(R.id.Ingresar);
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.irahome);
                Toast.makeText(getActivity(), "boton presionado", Toast.LENGTH_SHORT).show();
                Log.i("texto","si me ejecuto");
            }
        });
        return vista;
    }
}
