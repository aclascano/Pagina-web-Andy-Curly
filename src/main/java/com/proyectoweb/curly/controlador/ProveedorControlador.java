package com.proyectoweb.curly.controlador;

import com.proyectoweb.curly.modelo.Estudiante;
import com.proyectoweb.curly.modelo.Proveedor;
import com.proyectoweb.curly.modelo.Usuario;
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
public class ProveedorControlador {

    @Autowired
    private ProveedorServicio servicio;


    @GetMapping({ "/proveedores"})
    public String listarProveedore(Model modelo) {
        modelo.addAttribute("proveedores", servicio.listarProveedor());
        return "proveedor";
    }

    @GetMapping("/proveedores/nuevo")
    public String mostrarFormularioProveedores(Model modelo) {
        Proveedor proveedor = new Proveedor();
        modelo.addAttribute("proveedor", proveedor);
        return "proveedor_formulario";
    }

    @PostMapping("/proveedores")
    public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
        servicio.guardarProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/proveedores/editar/{id}")
    public String editarProveedor(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("proveedor", servicio.obtenerProveedorPorId(id));
        return "proveedor_formulario";
    }

    @PostMapping("/proveedores/{id}")
    public String actualizarProveedor(@PathVariable Integer id, @ModelAttribute("proveedor") Proveedor proveedor,
                                       Model modelo) {
        Proveedor proveedorExistente = servicio.obtenerProveedorPorId(id);
        proveedorExistente.setId_pro(id);
        proveedorExistente.setNombre_pro(proveedor.getNombre_pro());
        proveedorExistente.setTelefono_pro(proveedor.getTelefono_pro());
        proveedorExistente.setCorreo_pro(proveedor.getCorreo_pro());

        servicio.actualizarProveedor(proveedorExistente);
        return "redirect:/proveedores";
    }

    @GetMapping("/proveedores/{id}")
    public String eliminarProveedores(@PathVariable Integer id) {
        servicio.eliminarProveedor(id);
        return "redirect:/proveedores";
    }


}
