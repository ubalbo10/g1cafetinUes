package com.example.g1cafetinues.interfaces;

import com.example.g1cafetinues.clases.Local;
import com.example.g1cafetinues.clases.Repartidor;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServicesRepartidor {

    //get repartidores
    @GET("repartidor/")
    Call<List<Repartidor>> ObtenerRepartidores();

    //update
    @POST("actualizar-repartidor/")
    Call<Repartidor> actualizarRepartidor (@Path("idRepartidor") String idRepartidor,@Body Repartidor repartidor);

    //Delete
    @POST("eliminar-repartidor")
    Call<ResponseBody> deleteRepartidor(
            @Query("idRepartidor") String idRepartidor);

    //add
    @POST("crear-repartidor")
    Call<ResponseBody> createRepartidor(@Body Repartidor obj);

}



