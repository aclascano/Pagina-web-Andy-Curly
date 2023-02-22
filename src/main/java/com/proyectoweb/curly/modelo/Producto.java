package com.proyectoweb.curly.modelo;
import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    private String nombre;

    private Integer cantidad;

    private Double precio;

    private String descripccion;

    private String fotografia;


    @ManyToOne
    @JoinColumn(name= "id_cat")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name= "id_pro")
    private Proveedor proveedor;

    public Producto(Integer id_producto, String nombre, Integer cantidad, Double precio, String descripccion, String fotografia, Categoria categoria, Proveedor proveedor) {
        super();
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripccion = descripccion;
        this.fotografia = fotografia;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public Producto(String nombre, Integer cantidad, Double precio, String descripccion, String fotografia, Categoria categoria, Proveedor proveedor) {
        super();
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripccion = descripccion;
        this.fotografia = fotografia;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public Producto() {
        super();
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}

