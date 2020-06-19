package com.example.g1cafetinues.interfaces;

import com.example.g1cafetinues.clases.Categoria;
import com.example.g1cafetinues.clases.DetalleProductoPedido;
import com.example.g1cafetinues.clases.Encargado;
import com.example.g1cafetinues.clases.Local;
import com.example.g1cafetinues.clases.Producto;
import com.example.g1cafetinues.clases.ProductoApi;
import com.example.g1cafetinues.clases.Trabajador;
import com.example.g1cafetinues.clases.Usuario;
import com.google.gson.internal.bind.JsonTreeReader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServices {

    @POST("registrar-pedido-flujo")
    Call<String>GuardarPedido(@Query("idPedido") String id,
                              @Query("esParaLlevar") String esparallevar,
                              @Query("idUbicacion") String idUbicacion,
                              @Query("fechaPedido") String fecha,
                              @Query("nombreCliente") String nombrecliente,
                              @Query("detalle") ArrayList<Producto> detalle);
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
}


//group/{id}/users    Call<List<User>> groupList(@Path("id") int groupId);
//si ponemos query en lugar de path agrega ?nombre="guillermo"


//obtener y insertar ya los tenes listo de empleado