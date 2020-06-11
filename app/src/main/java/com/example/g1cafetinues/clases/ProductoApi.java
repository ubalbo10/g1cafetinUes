package com.example.g1cafetinues.clases;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductoApi {

    @SerializedName("IDPRODUCTO")
    @Expose
    private Integer iDPRODUCTO;
    @SerializedName("IDLOCAL")
    @Expose
    private Integer iDLOCAL;
    @SerializedName("IDCATEGORIA")
    @Expose
    private Integer iDCATEGORIA;
    @SerializedName("NOMBREPRODUCTO")
    @Expose
    private String nOMBREPRODUCTO;
    @SerializedName("PRECIOUNITARIO")
    @Expose
    private Double pRECIOUNITARIO;
    @SerializedName("EXISTENCIA")
    @Expose
    private Integer eXISTENCIA;
    @SerializedName("PRO_LOCAL")
    @Expose
    private Integer pROLOCAL;

    public Integer getIDPRODUCTO() {
        return iDPRODUCTO;
    }

    public void setIDPRODUCTO(Integer iDPRODUCTO) {
        this.iDPRODUCTO = iDPRODUCTO;
    }

    public Integer getIDLOCAL() {
        return iDLOCAL;
    }

    public void setIDLOCAL(Integer iDLOCAL) {
        this.iDLOCAL = iDLOCAL;
    }

    public Integer getIDCATEGORIA() {
        return iDCATEGORIA;
    }

    public void setIDCATEGORIA(Integer iDCATEGORIA) {
        this.iDCATEGORIA = iDCATEGORIA;
    }

    public String getNOMBREPRODUCTO() {
        return nOMBREPRODUCTO;
    }

    public void setNOMBREPRODUCTO(String nOMBREPRODUCTO) {
        this.nOMBREPRODUCTO = nOMBREPRODUCTO;
    }

    public Double getPRECIOUNITARIO() {
        return pRECIOUNITARIO;
    }

    public void setPRECIOUNITARIO(Double pRECIOUNITARIO) {
        this.pRECIOUNITARIO = pRECIOUNITARIO;
    }

    public Integer getEXISTENCIA() {
        return eXISTENCIA;
    }

    public void setEXISTENCIA(Integer eXISTENCIA) {
        this.eXISTENCIA = eXISTENCIA;
    }

    public Integer getPROLOCAL() {
        return pROLOCAL;
    }

    public void setPROLOCAL(Integer pROLOCAL) {
        this.pROLOCAL = pROLOCAL;
    }

}
