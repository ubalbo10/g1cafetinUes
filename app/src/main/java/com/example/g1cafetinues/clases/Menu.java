package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {

    @SerializedName("IDMENU")
    @Expose
    private Integer iDMENU;
    @SerializedName("PRECIOMENU")
    @Expose
    private Integer pRECIOMENU;
    @SerializedName("FECHADESDEMENU")
    @Expose
    private String fECHADESDEMENU;
    @SerializedName("FECHAHASTAMENU")
    @Expose
    private String fECHAHASTAMENU;

    public Integer getIDMENU() {
        return iDMENU;
    }

    public void setIDMENU(Integer iDMENU) {
        this.iDMENU = iDMENU;
    }

    public Integer getPRECIOMENU() {
        return pRECIOMENU;
    }

    public void setPRECIOMENU(Integer pRECIOMENU) {
        this.pRECIOMENU = pRECIOMENU;
    }

    public String getFECHADESDEMENU() {
        return fECHADESDEMENU;
    }

    public void setFECHADESDEMENU(String fECHADESDEMENU) {
        this.fECHADESDEMENU = fECHADESDEMENU;
    }

    public String getFECHAHASTAMENU() {
        return fECHAHASTAMENU;
    }

    public void setFECHAHASTAMENU(String fECHAHASTAMENU) {
        this.fECHAHASTAMENU = fECHAHASTAMENU;
    }

}
