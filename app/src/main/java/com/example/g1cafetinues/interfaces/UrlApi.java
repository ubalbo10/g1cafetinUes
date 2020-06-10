package com.example.g1cafetinues.interfaces;

import com.example.g1cafetinues.clases.Repartidor;
import com.example.g1cafetinues.ui.MantenimientoRepartidor.RetrofitRepartidor;

public class UrlApi {


        public UrlApi() {
        }
        public static String UrlBase="http://3.133.138.215:5000/";

        public static ApiServices getUserServices() {
                return RetrofitRepartidor.getRepartidor(UrlBase).create(ApiServices.class);
        }
}
