package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Facultad {

    @SerializedName("IDFACULTAD")
    @Expose
    private String iDFACULTAD;
    @SerializedName("NOMFACULTAD")
    @Expose
    private String nOMFACULTAD;

    public String getIDFACULTAD() {
        return iDFACULTAD;
    }

    public void setIDFACULTAD(String iDFACULTAD) {
        this.iDFACULTAD = iDFACULTAD;
    }

    public String getNOMFACULTAD() {
        return nOMFACULTAD;
    }

    public void setNOMFACULTAD(String nOMFACULTAD) {
        this.nOMFACULTAD = nOMFACULTAD;
    }

}
