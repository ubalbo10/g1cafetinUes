package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repartidor {
    @SerializedName("IDREPARTIDOR")
    @Expose
    private Integer IDREPARTIDOR;

    @SerializedName("NOMREPARTIDOR")
    @Expose
    private String NOMREPARTIDOR;

    @SerializedName("APEREPARTIDOR")
    @Expose
    private String APEREPARTIDOR;

    @SerializedName("TELREPARTIDOR")
    @Expose
    private Integer TELREPARTIDOR;

    public Repartidor(){}

    public Repartidor(Integer IDREPARTIDOR, String NOMBREREPARTIDOR, String APEREPARTIDOR, Integer TELREPARTIDOR) {
        this.IDREPARTIDOR = IDREPARTIDOR;
        this.NOMREPARTIDOR = NOMBREREPARTIDOR;
        this.APEREPARTIDOR = APEREPARTIDOR;
        this.TELREPARTIDOR = TELREPARTIDOR;
    }

    public Integer getIDREPARTIDOR() {
        return IDREPARTIDOR;
    }

    public void setIDREPARTIDOR(Integer IDREPARTIDOR) {
        this.IDREPARTIDOR = IDREPARTIDOR;
    }

    public String getNOMBREREPARTIDOR() {
        return NOMREPARTIDOR;
    }

    public void setNOMBREREPARTIDOR(String NOMBREREPARTIDOR) {
        this.NOMREPARTIDOR = NOMBREREPARTIDOR;
    }

    public String getAPEREPARTIDOR() {
        return APEREPARTIDOR;
    }

    public void setAPEREPARTIDOR(String APEREPARTIDOR) {
        this.APEREPARTIDOR = APEREPARTIDOR;
    }

    public Integer getTELREPARTIDOR() {
        return TELREPARTIDOR;
    }

    public void setTELREPARTIDOR(Integer TELREPARTIDOR) {
        this.TELREPARTIDOR = TELREPARTIDOR;
    }
}
