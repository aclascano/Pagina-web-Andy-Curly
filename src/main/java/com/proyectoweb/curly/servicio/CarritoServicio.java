package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Carrito;
import com.proyectoweb.curly.modelo.Categoria;

import java.util.List;

public interface CarritoServicio {

    public List<Carrito> listarCarritos();

    public Carrito guardarCarrito(Carrito carrito);

    public Carrito obtenerCarritoPorId(Integer id);

    public void eliminarCarrito(Integer id);
}
