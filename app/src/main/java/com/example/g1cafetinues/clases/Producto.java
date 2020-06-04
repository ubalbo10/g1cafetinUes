package com.example.g1cafetinues.clases;

public class Producto {
    String nombre;
    Float precioUnitario;
    Integer cantidad;
    Float total;
    public Producto(String nombre,Float precioUnitario,Integer cantidad,Float total){
        this.nombre=nombre;
        this.precioUnitario=precioUnitario;
        this.cantidad=cantidad;
        this.total=total;
    }
    public String getNombre(){
        return this.nombre;
    }
    public Float getPrecioUnitario(){
        return this.precioUnitario;
    }
    public Integer getCantidad(){
        return this.cantidad;
    }
    public Float getTotal(){
        return this.total;
    }

}
