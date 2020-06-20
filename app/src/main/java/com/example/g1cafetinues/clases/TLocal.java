package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TLocal {
    @SerializedName("IDLOCAL")
    @Expose
    private Integer IDLOCAL;

    @SerializedName("IDENCARGADO")
    @Expose
    private Integer IDENCARGADO;

    @SerializedName("NOMBRELOCAL")
    @Expose
    private String NOMBRELOCAL;

    public TLocal(){}

    public TLocal(Integer IDLOCAL, Integer IDENCARGADO, String NOMBRELOCAL) {
        this.IDLOCAL = IDLOCAL;
        this.IDENCARGADO = IDENCARGADO;
        this.NOMBRELOCAL = NOMBRELOCAL;
    }

    public Integer getIDLOCAL() {
        return IDLOCAL;
    }

    public void setIDLOCAL(Integer IDLOCAL) {
        this.IDLOCAL = IDLOCAL;
    }

    public Integer getIDENCARGADO() {
        return IDENCARGADO;
    }

    public void setIDENCARGADO(Integer IDENCARGADO) {
        this.IDENCARGADO = IDENCARGADO;
    }

    public String getNOMBRELOCAL() {
        return NOMBRELOCAL;
    }

    public void setNOMBRELOCAL(String NOMBRELOCAL) {
        this.NOMBRELOCAL = NOMBRELOCAL;
    }
}
