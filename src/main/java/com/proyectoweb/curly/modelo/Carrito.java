package com.proyectoweb.curly.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_car;

    @ManyToOne
    @JoinColumn(name= "id_cli")
    private Cliente cliente;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL)
    private List<LineaPedido> lineasPedido;

    public Carrito() {
        this.lineasPedido = new ArrayList<>();
    }

    public Carrito(Cliente cliente) {
        this.cliente = cliente;
        this.lineasPedido = new ArrayList<>();
    }

    public Integer getId_car() {
        return id_car;
    }

    public void setId_car(Integer id_car) {
        this.id_car = id_car;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void setLineasPedido(List<LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public void agregarLineaPedido(LineaPedido lineaPedido) {
        this.lineasPedido.add(lineaPedido);
        lineaPedido.setCarrito(this);
    }

    public void quitarLineaPedido(LineaPedido lineaPedido) {
        this.lineasPedido.remove(lineaPedido);
        lineaPedido.setCarrito(null);
    }
}

