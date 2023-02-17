package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Producto;

import java.util.List;

public interface ProductoServicio {
    public List<Producto> listarProductos();
    public List<String> listarNombresProductos();
    public List<Integer> listarCantidadProductos();

    public Producto guardarProductos(Producto producto);

    public Producto obtenerProductosPorId(Integer id);

    public Producto actualizarProductos(Producto producto);

    public void eliminarProductos(Integer id);

}
