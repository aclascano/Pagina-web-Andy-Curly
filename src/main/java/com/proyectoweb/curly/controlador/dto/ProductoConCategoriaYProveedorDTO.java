package com.proyectoweb.curly.controlador.dto;

public class ProductoConCategoriaYProveedorDTO {
    private Integer id;
    private String nombre;
    private Double precio;
    private String descripccion;
    private String fotografia;
    private String nombreCategoria;
    private String nombreProveedor;

    public ProductoConCategoriaYProveedorDTO(Integer id, String nombre, Double precio, String descripccion, String fotografia, String nombreCategoria, String nombreProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripccion = descripccion;
        this.fotografia = fotografia;
        this.nombreCategoria = nombreCategoria;
        this.nombreProveedor = nombreProveedor;
    }


}
