package com.proyectoweb.curly.controlador;

import com.proyectoweb.curly.modelo.Categoria;
import com.proyectoweb.curly.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio servicio;

    @GetMapping("/categorias")
    public String listarCategorias(Model modelo) {
        modelo.addAttribute("categorias", servicio.listarCategorias());
        return "categoria";
    }

    @GetMapping("/categorias/nuevo")
    public String mostrarFormularioCategorias(Model modelo) {
        Categoria categoria = new Categoria();
        modelo.addAttribute("categoria", categoria);
        return "categoria_formulario";
    }

    @PostMapping("/categorias")
    public String guardarCategorias(@ModelAttribute("categoria") Categoria categoria) {
        servicio.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("categoria", servicio.obtenerCategoriaPorId(id));
        return "categoria_formulario_editar";
    }

    @PostMapping("/categorias/{id}")
    public String actualizarCategoria(@PathVariable Integer id, @ModelAttribute("categoria") Categoria categoria, Model modelo) {
        Categoria categoriaExistente = servicio.obtenerCategoriaPorId(id);
        categoriaExistente.setId_cat(id);
        categoriaExistente.setNombre(categoria.getNombre());

        servicio.actualizarCategoria(categoriaExistente);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/{id}")
    public String eliminaCategoria(@PathVariable Integer id) {
        servicio.eliminarCategoria(id);
        return "redirect:/categorias";
    }

}
