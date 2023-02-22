package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Carrito;
import com.proyectoweb.curly.modelo.Producto;
import com.proyectoweb.curly.repositorio.CarritoRepositorio;
import com.proyectoweb.curly.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoServicioImpl implements CarritoServicio{
    @Autowired
    private CarritoRepositorio repositorio;

    @Override
    public List<Carrito> listarCarritos() {
        List<Carrito> carritos = repositorio.findAll();
        for (Carrito c : carritos){
            c.getCliente().getId_cli();
            c.getCliente().getNombre();
        }
        return carritos;
    }

    @Override
    public Carrito guardarCarrito(Carrito carrito) {
        return repositorio.save(carrito);
    }

    @Override
    public Carrito obtenerCarritoPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    @Override
    public void eliminarCarrito(Integer id) {
        repositorio.deleteById(id);

    }
}
