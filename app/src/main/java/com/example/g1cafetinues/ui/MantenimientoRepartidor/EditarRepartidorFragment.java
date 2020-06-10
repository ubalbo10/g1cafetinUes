package com.example.g1cafetinues.ui.MantenimientoRepartidor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashSet;
import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.Repartidor;
import android.app.Activity;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("NewApi")
public class EditarRepartidorFragment extends FragmentActivity {
    EditText edit_idRepartidor;
    EditText edit_NomRepartidor;
    EditText edit_ApeRepartidor;
    EditText edit_TelRepartidor;

    //URL WS, pedir a Kevin
    //private final String urlLocal = "http://192.168.1.7:8081/ws_aspirante_update.php";


    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_editar_repartidor);


        edit_idRepartidor = findViewById(R.id.edit_idRepartidor);
        edit_NomRepartidor = findViewById(R.id.edit_NomRepartidor);
        edit_ApeRepartidor = findViewById(R.id.edit_ApeRepartidor);
        edit_TelRepartidor = findViewById(R.id.edit_idRepartidor);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    private void setContentView(String fragment_editar_repartidor) {
    }

    public void limpiarTexto(View v) {
        edit_idRepartidor.setText("");
        edit_NomRepartidor.setText("");
        edit_ApeRepartidor.setText("");
        edit_TelRepartidor.setText("");
    }

    public EditarRepartidorFragment() {
        // Required empty public constructor
    }
}
