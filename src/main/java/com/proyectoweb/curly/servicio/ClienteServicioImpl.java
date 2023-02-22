package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Cliente;
import com.proyectoweb.curly.modelo.Producto;
import com.proyectoweb.curly.repositorio.ClienteRepositorio;
import com.proyectoweb.curly.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServicioImpl implements ClienteServicio{
    @Autowired
    private ClienteRepositorio repositorio;


    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = repositorio.findAll();
        for (Cliente p : clientes) {
            p.getUsuario().getId();
            p.getUsuario().getNombre();
        }
        return clientes;
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {
        repositorio.deleteById(id);
    }
}
