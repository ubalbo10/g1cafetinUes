package com.example.g1cafetinues.interfaces;

import com.example.g1cafetinues.clases.CambioPrecio;
import com.example.g1cafetinues.clases.DetalleProductoPedido;
import com.example.g1cafetinues.clases.Encargado;
import com.example.g1cafetinues.clases.EstadoPedido;
import com.example.g1cafetinues.clases.Facultad;
import com.example.g1cafetinues.clases.Local;
import com.example.g1cafetinues.clases.Repartidor;
import com.example.g1cafetinues.clases.TLocal;
import com.example.g1cafetinues.clases.Ubicacion;
import com.google.gson.internal.bind.JsonTreeReader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("locales")
    Call<List<Local>> ObtenerLocales();

    //Metodos para detalle producto pedido
    @POST("detalle-producto-pedido")
    Call<List<DetalleProductoPedido>> obtenerDetalleProductoPedido(@Query("IDDETALLE") Integer idDetalle);

    @POST("registrar-detalle-producto-pedido")
    Call<String> agregarDetalleProductoPedido(@Query("CANTIDADPEDIDO") Integer cantidad,
                                              @Query("IDDETALLE") Integer idDetalle,
                                              @Query("IDPEDIDO") Integer idPedido,
                                              @Query("IDPRODUCTO") Integer idProducto);

    @POST("actualizar-detalle-producto-pedido")
    Call<String> actualizarDetalleProductoPedido(@Query("CANTIDADPEDIDO") Integer cantidad,
                                                 @Query("IDDETALLE") Integer idDetalle,
                                                 @Query("IDPEDIDO") Integer idPedido,
                                                 @Query("IDPRODUCTO") Integer idProducto);

    @POST("eliminar-detalle-producto-pedido")
    Call<String> eliminarDetalleProductoPedido(@Query("IDDETALLE") Integer idDetalle);


    //////////////////////Metodos para Encargado////////////////////////////////////////
    @POST("obtener-encargado-local")
    Call<List<Encargado>> obtenerEncargado(@Query("IDENCARGADO") Integer idEncargado);

    @POST("registrar-encargado-local")
    Call<Encargado> agregarEncargado(@Query("IDENCARGADO") Integer idEncargado,
                                     @Query("NOMBRE") String nombre,
                                     @Query("APELLIDO") String apellido,
                                     @Query("TELEFONO") Integer telefono);

    @POST("actualizar-encargado-local")
    Call<Encargado> actualizarEncargado(@Query("IDENCARGADO") Integer idEncargado,
                                        @Query("NOMBRE") String nombre,
                                        @Query("APELLIDO") String apellido,
                                        @Query("TELEFONO") Integer telefono);

    @POST("eliminar-encargado-local")
    Call<List<DetalleProductoPedido>> eliminarEncargado(@Query("IDENCARGADO") Integer idEncargado);


    //////////////////////Metodos para CRUD LOCAL/////////////////////////////
    @POST("obtener-local")
    Call<List<TLocal>> obtenerLocal(@Query("IDLOCAL") Integer idLocal);

    @POST("registrar-local")
    Call<String> agregarLocal(@Query("IDLOCAL") Integer idLocal,
                              @Query("IDENCARGADOLOCAL") Integer idEncargado,
                              @Query("NOMBRELOCAL") String nombreLocal);

    @POST("actualizar-local")
    Call<String> actualizarLocal(@Query("IDLOCAL") Integer idLocal,
                                 @Query("IDENCARGADOLOCAL") Integer idEncargado,
                                 @Query("NOMBRELOCAL") String nombreLocal);

    @POST("eliminar-local")
    Call<String> eliminarLocal(@Query("IDLOCAL") Integer idLocal);


    //////////////////////Metodos para CRUD FACULTAD/////////////////////////////
    @POST("obtener-facultad")
    Call<List<Facultad>> obtenerFacultad(@Query("IDFACULTAD") Integer idFacultad);

    @POST("registrar-facultad")
    Call<String> agregarFacultad(@Query("IDFACULTAD") Integer idFacultad,
                              @Query("NOMFACULTAD") String nombreFacultad);

    @POST("actualizar-facultad")
    Call<String> actualizarFacultad(@Query("IDFACULTAD") Integer idFacultad,
                                 @Query("NOMFACULTAD") String nombreFacultad);

    @POST("eliminar-facultad")
    Call<String> eliminarFacultad(@Query("IDFACULTAD") Integer idFacultad);


    //////////////////////Metodo CRUD REPARTIDOR////////////////////////////////////////
    @POST("obtener-repartidor")
    Call<List<Repartidor>> obtenerRepartidor(@Query("IDREPARTIDOR") Integer idRepartidor);

    @POST("registrar-repartido")
    Call<String> agregarRepartidor(@Query("IDREPARTIDOR") Integer idRepartidor,
                                   @Query("NOMREPARTIDOR") String nombre,
                                   @Query("APEREPARTIDOR") String apellido,
                                   @Query("TELREPARTIDOR") Integer telefono);

    @POST("actualizar-repartidor")
    Call<String> actualizarRepartidor(@Query("IDREPARTIDOR") Integer idRepartidor,
                                      @Query("NOMREPARTIDOR") String nombre,
                                      @Query("APEREPARTIDOR") String apellido,
                                      @Query("TELREPARTIDOR") Integer telefono);

    @POST("eliminar-repartidor")
    Call<String> eliminarRepartidor(@Query("IDREPARTIDOR") Integer idRepartidor);



    //////////////////////Metodo CRUD ESTADO PEDIDO////////////////////////////////////////
    @POST("obtener-estado-pedido")
    Call<List<EstadoPedido>> obtenerEstadoPedido(@Query("IDESTADOPEDIDO") Integer idEstadoPedido);

    @POST("registrar-estado-pedido")
    Call<String> agregarEstadoPedido(@Query("IDESTADOPEDIDO") Integer idEstadoPedido,
                                     @Query("DESCESTADOPEDIDO") String desEstadoPedido);

    @POST("actualizar-estado-pedido")
    Call<String> actualizarEstadoPedido(@Query("IDESTADOPEDIDO") Integer idEstadoPedido,
                                      @Query("DESCESTADOPEDIDO") String desEstadoPedido);

    @POST("eliminar-estado-pedido")
    Call<String> eliminarEstadoPedido(@Query("IDESTADOPEDIDO") Integer idEstadoPedido);




    //////////////////////Metodo CRUD UBICACION////////////////////////////////////////
    @POST("obtener-ubicacion")
    Call<List<Ubicacion>> obtenerUbicacion(@Query("IDUBICACION") Integer idUbicacion);

    @POST("registrar-ubicacion")
    Call<String> agregarUbicacion(@Query("IDUBICACION") Integer idUbicacion,
                                     @Query("DESCUBICACION") String desUbicacion);

    @POST("actualizar-ubicacion")
    Call<String> actualizarUbicacion(@Query("IDUBICACION") Integer idUbicacion,
                                     @Query("DESCUBICACION") String desUbicacion);

    @POST("eliminar-ubicacion")
    Call<String> eliminarUbicacion(@Query("IDUBICACION") Integer idUbicacion);



    //////////////////////Metodo CRUD CAMBIO PRECIO////////////////////////////////////////
    @POST("obtener-cambio-precio")
    Call<List<CambioPrecio>> obtenerCambioPrecio(@Query("IDCAMBIOPRECIO") Integer idCambioPrecio);

    @POST("registrar-cambio-precio")
    Call<String> agregarCambioPrecio(@Query("IDCAMBIOPRECIO") Integer idCambioPrecio,
                                     @Query("IDPRODUCTO") Integer idProducto,
                                     @Query("FECHACAMBIO") String fechaCambio,
                                     @Query("PRECIONUEVO") Double precioNuevo);

    @POST("actualizar-cambio-precio")
    Call<String> actualizarCambioPrecio(@Query("IDCAMBIOPRECIO") Integer idCambioPrecio,
                                        @Query("IDPRODUCTO") Integer idProducto,
                                        @Query("FECHACAMBIO") String fechaCambio,
                                        @Query("PRECIONUEVO") Double precioNuevo);

    @POST("eliminar-cambio-precio")
    Call<String> eliminarCambioPrecio(@Query("IDCAMBIOPRECIO") Integer idCambioPrecio);

}

//group/{id}/users    Call<List<User>> groupList(@Path("id") int groupId);
//si ponemos query en lugar de path agrega ?nombre="guillermo"


