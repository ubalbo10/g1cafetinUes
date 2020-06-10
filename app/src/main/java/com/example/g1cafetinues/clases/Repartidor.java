package com.example.g1cafetinues.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repartidor {

    @SerializedName("IDREPARTIDOR")
    @Expose
    private String IDREPARTIDOR;
    @SerializedName("NOMREPARTIDOR")
    @Expose
    private String NOMREPARTIDOR;
    @SerializedName("APEREPARTIDOR")
    @Expose
    private String APEREPARTIDOR;
    @SerializedName("TELREPARTIDOR")
    @Expose
    private String TELREPARTIDOR;

    /**
     * No args constructor for use in serialization
     *
     */
    public Repartidor() {
    }


    /**
     *
     * @param IDREPARTIDOR
     * @param nOMREPARTIDOR
     * @param aPEREPARTIDOR
     * @param tELREPARTIDOR

     */
    public Repartidor (String IDREPARTIDOR, String nOMREPARTIDOR, String aPEREPARTIDOR, String tELREPARTIDOR) {
        super();
        this.IDREPARTIDOR = IDREPARTIDOR;
        this.NOMREPARTIDOR = nOMREPARTIDOR;
        this.APEREPARTIDOR = aPEREPARTIDOR;
        this.TELREPARTIDOR = tELREPARTIDOR;
    }

    public String getIDREPARTIDOR() {
        return IDREPARTIDOR;
    }

    public void setIDREPARTIDOR(String iDREPARTIDOR) {
        this.IDREPARTIDOR = iDREPARTIDOR;
    }

    public String getNOMREPARTIDOR() {
        return NOMREPARTIDOR;
    }

    public void setNOMREPARTIDOR(String nOMREPARTIDOR) {
        this.NOMREPARTIDOR = nOMREPARTIDOR;
    }

    public String getAPEREPARTIDOR() {
        return APEREPARTIDOR;
    }

    public void setAPEREPARTIDOR(String aPEREPARTIDOR) {
        this.APEREPARTIDOR = aPEREPARTIDOR;
    }

    public String getTELREPARTIDOR() {
        return TELREPARTIDOR;
    }

    public void setTELREPARTIDOR(String tELREPARTIDOR) {
        this.TELREPARTIDOR = tELREPARTIDOR;
    }
}
