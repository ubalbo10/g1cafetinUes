package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Facultad {
    @SerializedName("IDFACULTAD")
    @Expose
    private Integer IDFACULTAD;

    @SerializedName("NOMFACULTAD")
    @Expose
    private Integer NOMFACULTAD;

    public Facultad(){}

    public Facultad(Integer IDFACULTAD, Integer NOMFACULTAD) {
        this.IDFACULTAD = IDFACULTAD;
        this.NOMFACULTAD = NOMFACULTAD;
    }

    public Integer getIDFACULTAD() {
        return IDFACULTAD;
    }

    public void setIDFACULTAD(Integer IDFACULTAD) {
        this.IDFACULTAD = IDFACULTAD;
    }

    public Integer getNOMFACULTAD() {
        return NOMFACULTAD;
    }

    public void setNOMFACULTAD(Integer NOMFACULTAD) {
        this.NOMFACULTAD = NOMFACULTAD;
    }
}
