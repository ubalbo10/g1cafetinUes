package com.example.g1cafetinues.interfaces;

import com.example.g1cafetinues.clases.CambioPrecio;
import com.example.g1cafetinues.clases.Categoria;
import com.example.g1cafetinues.clases.DetalleProductoPedido;
import com.example.g1cafetinues.clases.Encargado;
import com.example.g1cafetinues.clases.EstadoPedido;
import com.example.g1cafetinues.clases.Facultad;
import com.example.g1cafetinues.clases.Local;
import com.example.g1cafetinues.clases.Menu;
import com.example.g1cafetinues.clases.Pedido;
import com.example.g1cafetinues.clases.ProductoApi;
import com.example.g1cafetinues.clases.Repartidor;
import com.example.g1cafetinues.clases.TLocal;
import com.example.g1cafetinues.clases.Trabajador;
import com.example.g1cafetinues.clases.Ubicacion;
import com.example.g1cafetinues.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServices {


    @POST("registrar-pedido-flujo")
    Call<String>GuardarPedido(@Query("idPedido") String id,
                              @Query("esParaLlevar") Integer esparallevar,
                              @Query("idUbicacion") String idUbicacion,
                              @Query("fechaPedido") String fecha,
                              @Query("nombreCliente") String nombrecliente,
                              @Query("detalle") ArrayList<String> detalle);
    //crud menu
    @POST("actualizar-menu")
    Call<String> ActualizarMenu(@Query("IDMENU") String idmenu,
                             @Query("PRECIOMENU") String precio,
                             @Query("FECHADESDEMENU") String fechaini,
                             @Query("FECHAHASTAMENU") String fechafin);

    @POST("registrar-menu")
    Call<String> AgregarMenu(@Query("IDMENU") String idmenu,
                                 @Query("PRECIOMENU") String precio,
                                 @Query("FECHADESDEMENU") String fechaini,
                                 @Query("FECHAHASTAMENU") String fechafin);
    //CONSULTAR
    @POST("obtener-menu")
    Call<Menu> ObtenerMenu(@Query("IDMENU") String idpedido);
    //borrar
    @POST("eliminar-menu")
    Call<String> EliminarMenu(@Query("IDMENU") String idpedido);

    //crud pedido
    @POST("actualizar-pedido")
    Call<String> ActualizarPedido(@Query("IDPEDIDO") String idpedido,
                               @Query("IDRUTA") String idruta,
                               @Query("IDESTADOPEDIDO") Integer idestado,
                               @Query("IDTRABAJADOR") String idtrabajador,
                               @Query("IDREPARTIDOR") String idrepartidor,
                               @Query("IDUBICACION") String idubicacion,
                               @Query("FECHAPEDIDO") String fecha,
                               @Query("CLIENTE") String cliente,
                               @Query("PARALLEVAR") Integer parallevar);

    @POST("registrar-pedido")
    Call<String> RegistrarPedido(@Query("IDPEDIDO") String idpedido,
                               @Query("IDRUTA") String idruta,
                               @Query("IDESTADOPEDIDO") String idestado,
                               @Query("IDTRABAJADOR") String idtrabajador,
                               @Query("IDREPARTIDOR") String idrepartidor,
                               @Query("IDUBICACION") String idubicacion,
                               @Query("FECHAPEDIDO") String fecha,
                               @Query("CLIENTE") String cliente,
                               @Query("PARALLEVAR") Integer parallevar);//CONSULTAR
    @POST("obtener-pedido")
    Call<Pedido> ObtenerPedido(@Query("IDPEDIDO") String idpedido);
    //borrar
    @POST("eliminar-pedido")
    Call<String> EliminarPedido(@Query("IDPEDIDO") String idpedido);


    //crud de categoria
    //crear categoria
    @POST("registrar-categoria")
    Call<String> RegistrarCategoria(@Query("IDCATEGORIA") String idcategoria,
                                    @Query("NOMBRECATEGORIA") String nombre);
    //ACTUALIZAR
    @POST("actualizar-categoria")
    Call<String> ActualizarCategoria(@Query("IDCATEGORIA") String idcategoria,
                                    @Query("NOMBRECATEGORIA") String nombre);
    //CONSULTAR
    @POST("obtener-categoria")
    Call<Categoria> ObtenerCategoria(@Query("IDCATEGORIA") String idcategoria);
    //borrar
    @POST("eliminar-categoria")
    Call<String> EliminarCategoria(@Query("IDCATEGORIA") String idcategoria);
    //fin//





    //CRUD DE PRODUCTOS
    //Crear producto
    @POST("registrar-producto")
    Call<String> RegistrarProducto(@Query("IDPRODUCTO") String idproducto,
                                   @Query("IDLOCAL") String idlocal,
                                   @Query("IDCATEGORIA") String idcategoria,
                                   @Query("NOMBREPRODUCTO") String nombre,
                                   @Query("PRECIOUNITARIO") String precio,
                                   @Query("EXISTENCIA") String Existencia,
                                   @Query("PRO_LOCAL") String Prolocal);

    @POST("actualizar-producto")
    Call<String> UpdateProducto(@Query("IDPRODUCTO") String idproducto,
                                @Query("IDLOCAL") String idlocal,
                                @Query("IDCATEGORIA") String idcategoria,
                                @Query("NOMBREPRODUCTO") String nombre,
                                @Query("PRECIOUNITARIO") String precio,
                                @Query("EXISTENCIA") String Existencia,
                                @Query("PRO_LOCAL") String Prolocal);

    @POST("obtener-productos-crud")
    Call<ProductoApi> ConsultarProducto(@Query("IDPRODUCTO") String idproducto);
    @POST("eliminar-producto")
    Call<String> BorrarProducto(@Query("IDPRODUCTO") String idproducto);
    //FIN DE CRUD DE PRODUCTOS

    //CRUD DE EMPLEADOS
    //obtener empleado
    @POST("obtener-empleado")
    Call<Trabajador> ObtenerTrabajador(@Query("Idtrabajador") String idtrabajador);
        //crear empleado
    @POST("registrar-empleado-ues")
    Call<String> RegistrarEmpleado(@Query("idTrabajador") String idTrabajador,
                                    @Query("IdLocal") String idLocal,
                                    @Query("idUbicacion") String idUbicacion,
                                    @Query("idFacultad") String idFacultad,
                                    @Query("nombre") String nombre,
                                    @Query("apellido") String apellido,
                                    @Query("tel") String tel);
    //Update empleado
    @POST("actualizar-empleado")
    Call<String> updateEmpleado(@Query("IDTRABAJADOR") String idtrabajador,
                                @Query("IDLOCAL") String IDLOCAL,
                                @Query("IDUBICACION") String IDUBICACION,
                                @Query("IDFACULTAD") String IDFACULTAD,
                                @Query("NOMTRABAJADOR") String NOMBRE,
                                @Query("APETRABAJADOR") String apellido,
                                @Query("TELTRABAJADOR") String tel);

    //delete empleado
    @POST("eliminar-empleado")
    Call<String> EliminarEmpleado(@Query("IDTRABAJADOR") String idtrabajador);
    //fin del crud de empleados


    //para el flujo normal
    //idlocal, idcategoria
    @POST("obtener-productos")
    Call<ArrayList<ProductoApi>> ObtenerProductosLocal(@Query("idlocal") String idlocal,
                                                       @Query("idcategoria") String idcategoria);
    //LOGGIN
    @POST("login")
    Call<Usuario> ObtenerLogin(@Query("usuario") String usuario, @Query("password") String password);

    //obtener todos los locales
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
    @POST("encargado/")
    Call<List<Encargado>> obtenerEncargado(@Query("IDENCARGADO") Integer idEncargado);

    @POST("encargado/")
    Call<Encargado> agregarEncargado(@Query("IDENCARGADO") Integer idEncargado,
                                     @Query("NOMBRE") String nombre,
                                     @Query("APELLIDO") String apellido,
                                     @Query("TELEFONO") Integer telefono);

    @POST("encargado/")
    Call<Encargado> actualizarEncargado(@Query("IDENCARGADO") Integer idEncargado,
                                        @Query("NOMBRE") String nombre,
                                        @Query("APELLIDO") String apellido,
                                        @Query("TELEFONO") Integer telefono);

    @POST("encargado")
    Call<List<DetalleProductoPedido>> eliminarEncargado(@Query("IDENCARGADO") Integer idEncargado);

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

    //VERIFICAR DESDE AQUI

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


}


//group/{id}/users    Call<List<User>> groupList(@Path("id") int groupId);
//si ponemos query en lugar de path agrega ?nombre="guillermo"


