package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ubicacion {

    @SerializedName("IDUBICACION")
    @Expose
    private Integer IDUBICACION;

    @SerializedName("DESCUBICACION")
    @Expose
    private String DESCUBICACION;

    public Ubicacion(){}

    public Ubicacion(Integer IDUBICACION, String DESCUBICACION) {
        this.IDUBICACION = IDUBICACION;
        this.DESCUBICACION = DESCUBICACION;
    }

    public Integer getIDUBICACION() {
        return IDUBICACION;
    }

    public void setIDUBICACION(Integer IDUBICACION) {
        this.IDUBICACION = IDUBICACION;
    }

    public String getDESCUBICACION() {
        return DESCUBICACION;
    }

    public void setDESCUBICACION(String DESCUBICACION) {
        this.DESCUBICACION = DESCUBICACION;
    }
}
