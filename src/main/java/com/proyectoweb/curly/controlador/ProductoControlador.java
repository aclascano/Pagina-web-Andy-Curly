package com.proyectoweb.curly.controlador;

import com.proyectoweb.curly.modelo.Estudiante;
import com.proyectoweb.curly.modelo.Producto;
import com.proyectoweb.curly.modelo.Usuario;
import com.proyectoweb.curly.servicio.ProductoServicio;
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

    @GetMapping("/productos")
    public String listarProductos(Model modelo) {
        modelo.addAttribute("productos", servicio.listarProductos());
        return "producto";
    }

}
