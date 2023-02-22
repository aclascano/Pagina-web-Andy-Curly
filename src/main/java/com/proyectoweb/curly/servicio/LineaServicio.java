package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Carrito;
import com.proyectoweb.curly.modelo.Direccion;
import com.proyectoweb.curly.modelo.LineaPedido;

import java.util.List;

public interface LineaServicio {

    public List<LineaPedido> listarLineas();

    public LineaPedido guardarLinea(LineaPedido lineaPedido);

    public LineaPedido obtenerLineaPorId(Integer id);

    public void eliminarLinea(Integer id);
    public List<LineaPedido> obtenerLineasPorIdCarrito(Integer idCarrito);


}
