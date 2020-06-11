package com.example.g1cafetinues.interfaces;

import com.example.g1cafetinues.clases.Local;
import com.example.g1cafetinues.clases.Trabajador;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServices {
    //obtener todos los locales
    @GET("locales")
    Call<List<Local>> ObtenerLocales();
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

    //LOGGIN

    @POST("login")
    Call<Trabajador> ObtenerLogin(@Body String usuario,@Body String password);



}


//group/{id}/users    Call<List<User>> groupList(@Path("id") int groupId);
//si ponemos query en lugar de path agrega ?nombre="guillermo"


//obtener y insertar ya los tenes listo de empleado