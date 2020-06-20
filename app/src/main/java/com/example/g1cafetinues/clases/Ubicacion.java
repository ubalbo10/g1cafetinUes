package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ubicacion {

    @SerializedName("IDUBICACION")
    @Expose
    private Integer IDUBICACION;

    @SerializedName("DESCUBICACION")
    @Expose
    private Integer DESCUBICACION;

    public Ubicacion(){}

    public Ubicacion(Integer IDUBICACION, Integer DESCUBICACION) {
        this.IDUBICACION = IDUBICACION;
        this.DESCUBICACION = DESCUBICACION;
    }

    public Integer getIDUBICACION() {
        return IDUBICACION;
    }

    public void setIDUBICACION(Integer IDUBICACION) {
        this.IDUBICACION = IDUBICACION;
    }

    public Integer getDESCUBICACION() {
        return DESCUBICACION;
    }

    public void setDESCUBICACION(Integer DESCUBICACION) {
        this.DESCUBICACION = DESCUBICACION;
    }
}
