package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pedido {

    @SerializedName("IDPEDIDO")
    @Expose
    private Integer iDPEDIDO;
    @SerializedName("IDRUTA")
    @Expose
    private Integer iDRUTA;
    @SerializedName("IDESTADOPEDIDO")
    @Expose
    private String iDESTADOPEDIDO;
    @SerializedName("IDTRABAJADOR")
    @Expose
    private String iDTRABAJADOR;
    @SerializedName("IDREPARTIDOR")
    @Expose
    private String iDREPARTIDOR;
    @SerializedName("IDUBICACION")
    @Expose
    private Integer iDUBICACION;
    @SerializedName("FECHAPEDIDO")
    @Expose
    private String fECHAPEDIDO;
    @SerializedName("CLIENTE")
    @Expose
    private String cLIENTE;
    @SerializedName("PARALLEVAR")
    @Expose
    private Integer pARALLEVAR;

    public Integer getIDPEDIDO() {
        return iDPEDIDO;
    }

    public void setIDPEDIDO(Integer iDPEDIDO) {
        this.iDPEDIDO = iDPEDIDO;
    }

    public Integer getIDRUTA() {
        return iDRUTA;
    }

    public void setIDRUTA(Integer iDRUTA) {
        this.iDRUTA = iDRUTA;
    }

    public String getIDESTADOPEDIDO() {
        return iDESTADOPEDIDO;
    }

    public void setIDESTADOPEDIDO(String iDESTADOPEDIDO) {
        this.iDESTADOPEDIDO = iDESTADOPEDIDO;
    }

    public String getIDTRABAJADOR() {
        return iDTRABAJADOR;
    }

    public void setIDTRABAJADOR(String iDTRABAJADOR) {
        this.iDTRABAJADOR = iDTRABAJADOR;
    }

    public String getIDREPARTIDOR() {
        return iDREPARTIDOR;
    }

    public void setIDREPARTIDOR(String iDREPARTIDOR) {
        this.iDREPARTIDOR = iDREPARTIDOR;
    }

    public Integer getIDUBICACION() {
        return iDUBICACION;
    }

    public void setIDUBICACION(Integer iDUBICACION) {
        this.iDUBICACION = iDUBICACION;
    }

    public String getFECHAPEDIDO() {
        return fECHAPEDIDO;
    }

    public void setFECHAPEDIDO(String fECHAPEDIDO) {
        this.fECHAPEDIDO = fECHAPEDIDO;
    }

    public String getCLIENTE() {
        return cLIENTE;
    }

    public void setCLIENTE(String cLIENTE) {
        this.cLIENTE = cLIENTE;
    }

    public Integer getPARALLEVAR() {
        return pARALLEVAR;
    }

    public void setPARALLEVAR(Integer pARALLEVAR) {
        this.pARALLEVAR = pARALLEVAR;
    }

}

