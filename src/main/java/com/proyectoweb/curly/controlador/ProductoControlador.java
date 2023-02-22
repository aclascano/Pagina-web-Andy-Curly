package com.proyectoweb.curly.controlador;

import com.proyectoweb.curly.modelo.*;
import com.proyectoweb.curly.servicio.CategoriaServicio;
import com.proyectoweb.curly.servicio.ProductoServicio;
import com.proyectoweb.curly.servicio.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio servicio;
    @Autowired
    private CategoriaServicio categoriaServicio;

    @Autowired
    private ProveedorServicio proveedorServicio;

    @GetMapping("/productos")
    public String listarProductos(Model modelo) {
        modelo.addAttribute("productos", servicio.listarProductos());
        return "producto";
    }

    @GetMapping("/productos/nuevo")
    public String mostrarFormularioProductos(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);

        List<Categoria> categorias = categoriaServicio.listarCategorias();
        modelo.addAttribute("categorias", categorias);

        List<Proveedor> proveedores = proveedorServicio.listarProveedor();
        modelo.addAttribute("proveedores", proveedores);

        return "producto_formulario";
    }

    @PostMapping("/productos")
    public String guardarProductos(@ModelAttribute("producto") Producto producto) {
        Categoria categoria = categoriaServicio.obtenerCategoriaPorId(producto.getCategoria().getId_cat());
        producto.setCategoria(categoria);

        Proveedor proveedor = proveedorServicio.obtenerProveedorPorId(producto.getProveedor().getId_pro());
        producto.setProveedor(proveedor);

        servicio.guardarProductos(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String editarProducto(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("producto", servicio.obtenerProductosPorId(id));

        List<Categoria> categorias = categoriaServicio.listarCategorias();
        modelo.addAttribute("categorias", categorias);

        List<Proveedor> proveedores = proveedorServicio.listarProveedor();
        modelo.addAttribute("proveedores", proveedores);
        return "producto_formulario_editar";
    }

    @PostMapping("/productos/{id}")
    public String actualizarProductoos(@PathVariable Integer id, @ModelAttribute("producto") Producto producto,
                                       Model modelo) {
        Producto productoExistente = servicio.obtenerProductosPorId(id);
        productoExistente.setId_producto(id);
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setCantidad(producto.getCantidad());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setDescripccion(producto.getDescripccion());
        productoExistente.setFotografia(producto.getFotografia());

        // Obtener categoría seleccionada por su id
        Categoria categoriaSeleccionada = categoriaServicio.obtenerCategoriaPorId(producto.getCategoria().getId_cat());
        productoExistente.setCategoria(categoriaSeleccionada);

        // Obtener proveedor seleccionado por su id
        Proveedor proveedorSeleccionado = proveedorServicio.obtenerProveedorPorId(producto.getProveedor().getId_pro());
        productoExistente.setProveedor(proveedorSeleccionado);

        servicio.actualizarProductos(productoExistente);

        


        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}")
    public String eliminarProductos(@PathVariable Integer id) {
        servicio.eliminarProductos(id);
        return "redirect:/productos";
    }

}
