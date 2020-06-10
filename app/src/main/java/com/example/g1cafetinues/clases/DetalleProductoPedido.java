package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetalleProductoPedido {

    @SerializedName("CANTIDADPEDIDO")
    @Expose
    private Integer CANTIDADPEDIDO;

    @SerializedName("IDDETALLE")
    @Expose
    private Integer IDDETALLE;

    @SerializedName("IDPEDIDO")
    @Expose
    private Integer IDPEDIDO;

    @SerializedName("IDPRODUCTO")
    @Expose
    private Integer IDPRODUCTO;

    public Integer getCANTIDADPEDIDO() {
        return CANTIDADPEDIDO;
    }

    public void setCANTIDADPEDIDO(Integer CANTIDADPEDIDO) {
        this.CANTIDADPEDIDO = CANTIDADPEDIDO;
    }

    public Integer getIDDETALLE() {
        return IDDETALLE;
    }

    public void setIDDETALLE(Integer IDDETALLE) {
        this.IDDETALLE = IDDETALLE;
    }

    public Integer getIDPEDIDO() {
        return IDPEDIDO;
    }

    public void setIDPEDIDO(Integer IDPEDIDO) {
        this.IDPEDIDO = IDPEDIDO;
    }

    public Integer getIDPRODUCTO() {
        return IDPRODUCTO;
    }

    public void setIDPRODUCTO(Integer IDPRODUCTO) {
        this.IDPRODUCTO = IDPRODUCTO;
    }

    public DetalleProductoPedido(Integer CANTIDADPEDIDO, Integer IDDETALLE, Integer IDPEDIDO, Integer IDPRODUCTO) {
        this.CANTIDADPEDIDO = CANTIDADPEDIDO;
        this.IDDETALLE = IDDETALLE;
        this.IDPEDIDO = IDPEDIDO;
        this.IDPRODUCTO = IDPRODUCTO;
    }

    public DetalleProductoPedido(){}
}
