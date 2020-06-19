package com.example.g1cafetinues.clases;

public class Producto {
    String idlocal;
    String idproducto;
    String nombre;
    Float precioUnitario;
    Integer cantidad;
    Float total;
    public Producto(String idlocal,String idproducto,String nombre,Float precioUnitario,Integer cantidad,Float total){
        this.nombre=nombre;
        this.idlocal=idlocal;
        this.idproducto=idproducto;
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
    public String getIdProducto(){
        return this.idproducto;
    }

}
