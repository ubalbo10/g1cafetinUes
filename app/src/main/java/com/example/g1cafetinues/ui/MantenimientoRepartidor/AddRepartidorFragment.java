package com.example.g1cafetinues.ui.MantenimientoRepartidor;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.g1cafetinues.MainActivity;
import com.example.g1cafetinues.R;
import com.example.g1cafetinues.clases.Repartidor;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.lang.Class;
import com.example.g1cafetinues.ui.MantenimientoRepartidor.RetrofitRepartidor;

    public class AddRepartidorFragment extends AppCompatActivity {
    
    private RetrofitRepartidor apiServices;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_repartidor);
        //apiServices = RetrofitRepartidor.getRepartidor().create(RetrofitRepartidor.class);
        callCreateAPI();
    }

    public void callCreateAPI() {
        // create user body object
        Repartidor obj = new Repartidor();
        obj.setIDREPARTIDOR("6");
        obj.setNOMREPARTIDOR("Micheal");
        obj.setAPEREPARTIDOR("Chennai");
        obj.setTELREPARTIDOR("12345678");
        apiServices.addRepartidor(obj).enqueue(new Callback<ResponseBody>() {
            private static final String TAG = "AddRepartidorFragment";

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String message = response.message();
                int status = response.code();
                Log.i(TAG, "status : " + status);
                Toast.makeText(AddRepartidorFragment.this, "Created User Successfully", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    private void inciarControles() {

    }
}


