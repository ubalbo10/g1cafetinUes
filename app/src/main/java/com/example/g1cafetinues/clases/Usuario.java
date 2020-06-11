package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("IDUSUARIO")
    @Expose
    private String IDUSUARIO;
    @SerializedName("IDTIPOUSUARIO")
    @Expose
    private Integer IDTIPOUSUARIO;
    @SerializedName("NOMUSUARIO")
    @Expose
    private String NOMUSUARIO;
    @SerializedName("CLAVE")
    @Expose
    private String CLAVE;

    public String getIDUSUARIO() {
        return IDUSUARIO;
    }

    public void setIDUSUARIO(String iDUSUARIO) {
        this.IDUSUARIO = iDUSUARIO;
    }

    public Integer getIDTIPOUSUARIO() {
        return IDTIPOUSUARIO;
    }

    public void setIDTIPOUSUARIO(Integer iDTIPOUSUARIO) {
        this.IDTIPOUSUARIO = iDTIPOUSUARIO;
    }

    public String getNOMUSUARIO() {
        return NOMUSUARIO;
    }

    public void setNOMUSUARIO(String nOMUSUARIO) {
        this.NOMUSUARIO = nOMUSUARIO;
    }

    public String getCLAVE() {
        return CLAVE;
    }

    public void setCLAVE(String cLAVE) {
        this.CLAVE = cLAVE;
    }

}
