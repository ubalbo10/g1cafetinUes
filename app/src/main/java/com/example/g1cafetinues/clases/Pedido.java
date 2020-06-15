package com.example.g1cafetinues.clases;

import android.text.format.Time;
public class Pedido {

    private int iDPEDIDO;
    private int iDRUTA;
    private String iDESTADOPEDIDO;
    private String iDTRABAJADOR;
    private String iDREPARTIDOR;
    private int iDUBICACION;
    private String fECHAPEDIDO;
    private String cLIENTE;
    private int pARALLEVAR;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pedido() {
    }

    /**
     *
     * @param iDUBICACION
     * @param iDPEDIDO
     * @param iDESTADOPEDIDO
     * @param cLIENTE
     * @param pARALLEVAR
     * @param iDREPARTIDOR
     * @param iDRUTA
     * @param iDTRABAJADOR
     * @param fECHAPEDIDO
     */
    public Pedido(int iDPEDIDO, int iDRUTA, String iDESTADOPEDIDO, String iDTRABAJADOR, String iDREPARTIDOR, int iDUBICACION, String fECHAPEDIDO, String cLIENTE, int pARALLEVAR) {
        super();
        this.iDPEDIDO = iDPEDIDO;
        this.iDRUTA = iDRUTA;
        this.iDESTADOPEDIDO = iDESTADOPEDIDO;
        this.iDTRABAJADOR = iDTRABAJADOR;
        this.iDREPARTIDOR = iDREPARTIDOR;
        this.iDUBICACION = iDUBICACION;
        this.fECHAPEDIDO = fECHAPEDIDO;
        this.cLIENTE = cLIENTE;
        this.pARALLEVAR = pARALLEVAR;
    }

    public int getIDPEDIDO() {
        return iDPEDIDO;
    }

    public void setIDPEDIDO(int iDPEDIDO) {
        this.iDPEDIDO = iDPEDIDO;
    }

    public int getIDRUTA() {
        return iDRUTA;
    }

    public void setIDRUTA(int iDRUTA) {
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

    public int getIDUBICACION() {
        return iDUBICACION;
    }

    public void setIDUBICACION(int iDUBICACION) {
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

    public int getPARALLEVAR() {
        return pARALLEVAR;
    }

    public void setPARALLEVAR(int pARALLEVAR) {
        this.pARALLEVAR = pARALLEVAR;
    }

}