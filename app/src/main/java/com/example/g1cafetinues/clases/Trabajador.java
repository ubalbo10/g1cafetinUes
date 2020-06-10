package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trabajador {

    @SerializedName("IDTRABAJADOR")
    @Expose
    private String IDTRABAJADOR;
    @SerializedName("IDLOCAL")
    @Expose
    private Integer IDLOCAL;
    @SerializedName("IDUBICACION")
    @Expose
    private Integer IDUBICACION;
    @SerializedName("IDFACULTAD")
    @Expose
    private String IDFACULTAD;
    @SerializedName("NOMTRABAJADOR")
    @Expose
    private String NOMTRABAJADOR;
    @SerializedName("APETRABAJADOR")
    @Expose
    private String APETRABAJADOR;
    @SerializedName("TELTRABAJADOR")
    @Expose
    private String TELTRABAJADOR;

    public String getIDTRABAJADOR() {
        return IDTRABAJADOR;
    }

    public void setIDTRABAJADOR(String iDTRABAJADOR) {
        this.IDTRABAJADOR = iDTRABAJADOR;
    }

    public Integer getIDLOCAL() {
        return IDLOCAL;
    }

    public void setIDLOCAL(Integer iDLOCAL) {
        this.IDLOCAL = iDLOCAL;
    }

    public Integer getIDUBICACION() {
        return IDUBICACION;
    }

    public void setIDUBICACION(Integer iDUBICACION) {
        this.IDUBICACION = iDUBICACION;
    }

    public String getIDFACULTAD() {
        return IDFACULTAD;
    }

    public void setIDFACULTAD(String iDFACULTAD) {
        this.IDFACULTAD = iDFACULTAD;
    }

    public String getNOMTRABAJADOR() {
        return NOMTRABAJADOR;
    }

    public void setNOMTRABAJADOR(String nOMTRABAJADOR) {
        this.NOMTRABAJADOR = nOMTRABAJADOR;
    }

    public String getAPETRABAJADOR() {
        return APETRABAJADOR;
    }

    public void setAPETRABAJADOR(String aPETRABAJADOR) {
        this.APETRABAJADOR = aPETRABAJADOR;
    }

    public String getTELTRABAJADOR() {
        return TELTRABAJADOR;
    }

    public void setTELTRABAJADOR(String tELTRABAJADOR) {
        this.TELTRABAJADOR = tELTRABAJADOR;
    }

}

