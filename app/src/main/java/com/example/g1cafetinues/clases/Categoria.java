package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categoria {

    @SerializedName("IDCATEGORIA")
    @Expose
    private Integer iDCATEGORIA;
    @SerializedName("NOMBRECATEGORIA")
    @Expose
    private String nOMBRECATEGORIA;

    public Integer getIDCATEGORIA() {
        return iDCATEGORIA;
    }

    public void setIDCATEGORIA(Integer iDCATEGORIA) {
        this.iDCATEGORIA = iDCATEGORIA;
    }

    public String getNOMBRECATEGORIA() {
        return nOMBRECATEGORIA;
    }

    public void setNOMBRECATEGORIA(String nOMBRECATEGORIA) {
        this.nOMBRECATEGORIA = nOMBRECATEGORIA;
    }

}
