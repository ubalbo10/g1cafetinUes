package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CambioPrecio {
    @SerializedName("IDCAMBIOPRECIO")
    @Expose
    private Integer IDCAMBIOPRECIO;

    @SerializedName("IDPRODUCTO")
    @Expose
    private Integer IDPRODUCTO;

    @SerializedName("FECHACAMBIO")
    @Expose
    private String FECHACAMBIO;

    @SerializedName("PRECIONUEVO")
    @Expose
    private Double PRECIONUEVO;

    public CambioPrecio(){}

    public CambioPrecio(Integer IDCAMBIOPRECIO, Integer IDPRODUCTO, String FECHACAMBIO, Double PRECIONUEVO) {
        this.IDCAMBIOPRECIO = IDCAMBIOPRECIO;
        this.IDPRODUCTO = IDPRODUCTO;
        this.FECHACAMBIO = FECHACAMBIO;
        this.PRECIONUEVO = PRECIONUEVO;
    }

    public Integer getIDCAMBIOPRECIO() {
        return IDCAMBIOPRECIO;
    }

    public void setIDCAMBIOPRECIO(Integer IDCAMBIOPRECIO) {
        this.IDCAMBIOPRECIO = IDCAMBIOPRECIO;
    }

    public Integer getIDPRODUCTO() {
        return IDPRODUCTO;
    }

    public void setIDPRODUCTO(Integer IDPRODUCTO) {
        this.IDPRODUCTO = IDPRODUCTO;
    }

    public String getFECHACAMBIO() {
        return FECHACAMBIO;
    }

    public void setFECHACAMBIO(String FECHACAMBIO) {
        this.FECHACAMBIO = FECHACAMBIO;
    }

    public Double getPRECIONUEVO() {
        return PRECIONUEVO;
    }

    public void setPRECIONUEVO(Double PRECIONUEVO) {
        this.PRECIONUEVO = PRECIONUEVO;
    }
}
