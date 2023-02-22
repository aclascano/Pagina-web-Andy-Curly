package com.proyectoweb.curly.modelo;

import javax.persistence.*;

@Entity
@Table(name="lineapedido")
public class LineaPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_linea;

    @ManyToOne
    @JoinColumn(name = "id_car")
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "id_pro")
    private Producto producto;

    private Integer cantidad;

    public LineaPedido() {
    }

    public LineaPedido(Carrito carrito, Producto producto, Integer cantidad) {
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Integer getId_linea() {
        return id_linea;
    }

    public void setId_linea(Integer id_linea) {
        this.id_linea = id_linea;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}