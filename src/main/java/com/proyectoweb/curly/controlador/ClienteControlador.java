package com.proyectoweb.curly.controlador;

import com.proyectoweb.curly.modelo.*;
import com.proyectoweb.curly.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio servicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private  DireccionServicio direccionServicio;


    @GetMapping("/clientes")
    public String listarClientes(Model modelo) {
        modelo.addAttribute("clientes", servicio.listarClientes());
        return "cliente";
    }

    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioCliente(Model modelo) {

        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente", cliente);


        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        modelo.addAttribute("usuarios", usuarios);

        return "cliente_formulario";
    }

    @PostMapping("/clientes")
    public String guardarClientes(@ModelAttribute("cliente") Cliente cliente) {
        Usuario usuario = usuarioServicio.obtenerUsuarioPorId(cliente.getUsuario().getId());
        cliente.setUsuario(usuario);

        servicio.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/direcciones/{id}")
    public String mostrarFormularioDireccion(@PathVariable Integer id, Model modelo) {
        Direccion direccion = new Direccion();
        modelo.addAttribute("direccion", direccion);
        modelo.addAttribute("cliente", servicio.obtenerClientePorId(id));
        return "direccion_formulario";
    }

    //VER LAS DIRECCIONES QUE POSEE UN CLIENTE
    @GetMapping("/clientes/{id}/direcciones")
    public String mostrarDireccionesCliente(@PathVariable Integer id, Model modelo) {

        modelo.addAttribute("cliente", servicio.obtenerClientePorId(id));

        List<Direccion> direcciones = direccionServicio.listarDireccionesPorClienteId(id);
        modelo.addAttribute("direcciones", direcciones);

        return "direccion_cliente";
    }

    @PostMapping("/clientes/{id}/direcciones")
    public String guardarDirecciones(@PathVariable Integer id, @ModelAttribute("direccion") Direccion direccion, Model model) {

        // Buscar el cliente por su ID
        Cliente cliente = servicio.obtenerClientePorId(id);

        // Guardar la dirección en la tabla de direcciones
        Direccion nuevaDireccion = direccionServicio.guardarDireccion(direccion);

        // Agregar la nueva dirección al conjunto de direcciones del cliente
        cliente.getDireccion().add(nuevaDireccion);

        // Guardar el cliente actualizado en la base de datos
        servicio.actualizarCliente(cliente);

        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}")
    public String eliminarCliente(@PathVariable Integer id) {
        servicio.eliminarCliente(id);
        return "redirect:/clientes";
    }





}
