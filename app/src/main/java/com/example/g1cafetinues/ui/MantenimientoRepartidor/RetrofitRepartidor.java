package com.example.g1cafetinues.ui.MantenimientoRepartidor;

import com.example.g1cafetinues.clases.Repartidor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRepartidor {

    private static Retrofit retrofit = null;

        public static Retrofit getRepartidor(String url){
            if(retrofit == null){
                retrofit = new Retrofit.Builder().baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }

            return retrofit;
        }

    public static void getRepartidor() {
    }

    public void addRepartidor(Repartidor obj) {
    }
}
