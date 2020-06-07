package com.example.g1cafetinues.interfaces;

import com.example.g1cafetinues.clases.Local;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("locales")
    Call<List<Local>> ObtenerLocales();
}


//group/{id}/users    Call<List<User>> groupList(@Path("id") int groupId);
//si ponemos query en lugar de path agrega ?nombre="guillermo"


