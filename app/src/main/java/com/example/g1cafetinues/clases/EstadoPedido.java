package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EstadoPedido {
    @SerializedName("IDESTADOPEDIDO")
    @Expose
    private Integer IDESTADOPEDIDO;

    @SerializedName("DESCESTADOPEDIDO")
    @Expose
    private String DESCESTADOPEDIDO;

    public EstadoPedido(){}

    public EstadoPedido(Integer IDESTADOPEDIDO, String DESCESTADOPEDIDO) {
        this.IDESTADOPEDIDO = IDESTADOPEDIDO;
        this.DESCESTADOPEDIDO = DESCESTADOPEDIDO;
    }

    public Integer getIDESTADOPEDIDO() {
        return IDESTADOPEDIDO;
    }

    public void setIDESTADOPEDIDO(Integer IDESTADOPEDIDO) {
        this.IDESTADOPEDIDO = IDESTADOPEDIDO;
    }

    public String getDESCESTADOPEDIDO() {
        return DESCESTADOPEDIDO;
    }

    public void setDESCESTADOPEDIDO(String DESCESTADOPEDIDO) {
        this.DESCESTADOPEDIDO = DESCESTADOPEDIDO;
    }
}
