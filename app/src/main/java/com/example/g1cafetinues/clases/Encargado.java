package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Encargado {
    @SerializedName("IDENCARGADO")
    @Expose
    private Integer IDENCARGADO;

    @SerializedName("NOMBRE")
    @Expose
    private String NOMBRE;

    @SerializedName("APELLIDO")
    @Expose
    private String APELLIDO;

    @SerializedName("TELEFONO")
    @Expose
    private Integer TELEFONO;

    public Encargado(){}

    public Encargado(Integer IDENCARGADO, String NOMBRE, String APELLIDO, Integer TELEFONO) {
        this.IDENCARGADO = IDENCARGADO;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.TELEFONO = TELEFONO;
    }

    public Integer getIDENCARGADO() {
        return IDENCARGADO;
    }

    public void setIDENCARGADO(Integer IDENCARGADO) {
        this.IDENCARGADO = IDENCARGADO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public Integer getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(Integer TELEFONO) {
        this.TELEFONO = TELEFONO;
    }
}
