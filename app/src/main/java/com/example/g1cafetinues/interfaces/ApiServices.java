package com.example.g1cafetinues.interfaces;

import com.example.g1cafetinues.clases.Local;
import com.example.g1cafetinues.clases.Pedido;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("locales")
    Call<List<Local>> ObtenerLocales();

    @GET("pedido")
    Call<List<Pedido>> ObtenerPedidos(@Query("IDPEDIDO") int IDPEDIDO);

    @POST("pedido")
    Call<List<Pedido>> ObtenerPedidosPost();

    @GET("pedido")
    Call<Pedido> ObtenerPedido(@Query("ID") int IDPEDIDO);


}




//group/{id}/users    Call<List<User>> groupList(@Path("id") int groupId);
//si ponemos query en lugar de path agrega ?nombre="guillermo"


