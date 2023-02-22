package com.proyectoweb.curly.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ped;

    @ManyToOne
    @JoinColumn(name= "id_car")
    private Carrito carrito;

    private Double total;

    private String comprobante;

    private String verificacion;

    private String estado;

    private LocalDate fecha = LocalDate.now();

    public Pedido(Integer id_ped, Carrito carrito, Double total, String comprobante, String verificacion, String estado, LocalDate fecha) {
        this.id_ped = id_ped;
        this.carrito = carrito;
        this.total = total;
        this.comprobante = comprobante;
        this.verificacion = verificacion;
        this.estado = estado;
        this.fecha = fecha;
    }
    public Pedido(Carrito carrito, Double total, String comprobante, String verificacion, String estado, LocalDate fecha) {
        this.carrito = carrito;
        this.total = total;
        this.comprobante = comprobante;
        this.verificacion = verificacion;
        this.estado = estado;
        this.fecha = fecha;
    }
    public Pedido() {

    }

    public Integer getId_ped() {
        return id_ped;
    }

    public void setId_ped(Integer id_ped) {
        this.id_ped = id_ped;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(String verificacion) {
        this.verificacion = verificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
