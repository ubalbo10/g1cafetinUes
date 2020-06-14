package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Local {

    @SerializedName("IDLOCAL")
    @Expose
    private Integer IDLOCAL;
    @SerializedName("IDENCARGADOLOCAL")
    @Expose
    private Integer IDENCARGADOLOCAL;
    @SerializedName("NOMBRELOCAL")
    @Expose
    private String NOMBRE;
    @SerializedName("DIRECCION")
    @Expose
    private String DIRECCION;
    @SerializedName("TELEFONO")
    @Expose
    private String TELEFONO;
    @SerializedName("ESTADO")
    @Expose
    private Integer ESTADO;

    /**
     * No args constructor for use in serialization
     *
     */
    public Local() {
    }

    /**
     *
     * @param IDENCARGADOLOCAL
     * @param eSTADO
     * @param tELEFONO
     * @param IDLOCAL
     * @param nOMBRE
     * @param dIRECCION
     */
    public Local(Integer IDLOCAL, Integer IDENCARGADOLOCAL, String nOMBRE, String dIRECCION, String tELEFONO, Integer eSTADO) {
        super();
        this.IDLOCAL = IDLOCAL;
        this.IDENCARGADOLOCAL = IDENCARGADOLOCAL;
        this.NOMBRE = nOMBRE;
        this.DIRECCION = dIRECCION;
        this.TELEFONO = tELEFONO;
        this.ESTADO = eSTADO;
    }

    public Integer getIDLOCAL() {
        return IDLOCAL;
    }

    public void setIDLOCAL(Integer iDLOCAL) {
        this.IDLOCAL = iDLOCAL;
    }

    public Integer getIDENCARGADOLOCAL() {
        return IDENCARGADOLOCAL;
    }

    public void setIDENCARGADOLOCAL(Integer iDENCARGADOLOCAL) {
        this.IDENCARGADOLOCAL = iDENCARGADOLOCAL;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String nOMBRE) {
        this.NOMBRE = nOMBRE;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String dIRECCION) {
        this.DIRECCION = dIRECCION;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String tELEFONO) {
        this.TELEFONO = tELEFONO;
    }

    public Integer getESTADO() {
        return ESTADO;
    }

    public void setESTADO(Integer eSTADO) {
        this.ESTADO = eSTADO;
    }

}
