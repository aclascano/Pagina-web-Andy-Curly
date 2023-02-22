package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Carrito;
import com.proyectoweb.curly.modelo.LineaPedido;
import com.proyectoweb.curly.repositorio.CarritoRepositorio;
import com.proyectoweb.curly.repositorio.LineaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineaServicioImpl implements LineaServicio{
    @Autowired
    private LineaRepositorio repositorio;
    
    @Override
    public List<LineaPedido> listarLineas() {
        List<LineaPedido> lineas = repositorio.findAll();
        for (LineaPedido l : lineas){
            l.getCarrito().getId_car();
            l.getCarrito().getCliente().getId_cli();
            l.getCarrito().getCliente().getNombre();
            l.getProducto().getId_producto();
            l.getProducto().getNombre();
        }
        return lineas;
    }

    @Override
    public LineaPedido guardarLinea(LineaPedido linea) {
        return repositorio.save(linea);
    }

    @Override
    public LineaPedido obtenerLineaPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    @Override
    public void eliminarLinea(Integer id) {
        repositorio.deleteById(id);

    }

    @Override
    public List<LineaPedido> obtenerLineasPorIdCarrito(Integer idCarrito) {
        return repositorio.findByCarritoId(idCarrito);
    }

}
