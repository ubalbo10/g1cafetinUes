package com.example.g1cafetinues.interfaces;

import com.example.g1cafetinues.clases.Local;
import com.example.g1cafetinues.clases.Repartidor;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("locales")
    Call<List<Local>> ObtenerLocales();

    //get repartidores
    @GET("repartidor/")
    Call<List<Repartidor>> ObtenerRepartidores();

    //update
    @POST("actualizar-repartidor/")
    Call<Repartidor> actualizarRepartidor(@Path("idRepartidor") String idRepartidor, @Body Repartidor repartidor);

    //Delete
    @POST("eliminar-repartidor")
    Call<ResponseBody> eliminarRepartidor(
            @Query("idRepartidor") String idRepartidor);

    //add
    @POST("crear-repartidor")
    Call<ResponseBody> createRepartidor(@Body Repartidor obj);




//group/{id}/users    Call<List<User>> groupList(@Path("id") int groupId);
//si ponemos query en lugar de path agrega ?nombre="guillermo"


}