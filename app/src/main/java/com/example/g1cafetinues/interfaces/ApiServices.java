package com.example.g1cafetinues.interfaces;

import com.example.g1cafetinues.clases.DetalleProductoPedido;
import com.example.g1cafetinues.clases.Local;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("locales")
    Call<List<Local>> ObtenerLocales();

    @POST("detalle-producto-pedido/")
    Call<List<DetalleProductoPedido>> obtenerDetalleProductoPedido(@Query("IDDETALLE") Integer idDetalle);

    @POST("detalle-producto-pedido/")
    Call<DetalleProductoPedido> agregarDetalleProductoPedido(@Query("detalle") DetalleProductoPedido detalle);

    @POST("detalle-producto-pedido/")
    Call<DetalleProductoPedido> actualizarDetalleProductoPedido(@Query("detalle") DetalleProductoPedido detalle);

    @POST("detalle-producto-pedido/")
    Call<List<DetalleProductoPedido>> eliminarDetalleProductoPedido(@Query("IDDETALLE") Integer idDetalle);
}


//group/{id}/users    Call<List<User>> groupList(@Path("id") int groupId);
//si ponemos query en lugar de path agrega ?nombre="guillermo"


