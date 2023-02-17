package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Producto;
import com.proyectoweb.curly.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio{
    @Autowired
    private ProductoRepositorio repositorio;

    @Override
    public List<Producto> listarProductos() {
        List<Producto> productos = repositorio.findAll();
        for (Producto p : productos) {
            p.getCategoria().getId_cat();
            p.getCategoria().getNombre();
            p.getProveedor().getId_pro();
            p.getProveedor().getNombre_pro();
        }
        return productos;
    }
    public List<String> listarNombresProductos() {
        List<Producto> productos = repositorio.findAll();
        List<String> nombresProductos = new ArrayList<>();
        for (Producto producto : productos) {
            nombresProductos.add(producto.getNombre());
        }
        return nombresProductos;
    }

    public List<Integer> listarCantidadProductos() {
        List<Producto> productos = repositorio.findAll();
        List<Integer> cantidadesProductos = new ArrayList<>();
        for (Producto producto : productos) {
            cantidadesProductos.add(producto.getCantidad());
        }
        return cantidadesProductos;
    }

    @Override
    public Producto guardarProductos(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public Producto obtenerProductosPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Producto actualizarProductos(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public void eliminarProductos(Integer id) {
        repositorio.deleteById(id);
    }
}
