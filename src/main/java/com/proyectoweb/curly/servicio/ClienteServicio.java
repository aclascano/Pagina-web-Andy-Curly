package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Categoria;
import com.proyectoweb.curly.modelo.Cliente;

import java.util.List;

public interface ClienteServicio {

	public List<Cliente> listarClientes();
	
	public Cliente guardarCliente(Cliente cliente);
	
	public Cliente obtenerClientePorId(Integer id);
	
	public Cliente actualizarCliente(Cliente cliente);
	
	public void eliminarCliente(Integer id);
}
