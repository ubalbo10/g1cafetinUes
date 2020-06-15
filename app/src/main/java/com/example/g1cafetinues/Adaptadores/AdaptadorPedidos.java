package com.example.g1cafetinues.Adaptadores;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdaptadorPedidos {

    Retrofit retrofit;

    public AdaptadorPedidos(){

    }

    public Retrofit getAdaptador(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://3.133.138.215:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         return retrofit;
    }
}
