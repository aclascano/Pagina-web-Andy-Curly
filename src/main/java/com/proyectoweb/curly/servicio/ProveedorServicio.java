package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Proveedor;

import java.util.List;

public interface ProveedorServicio {

	public List<Proveedor> listarProveedor();
	
	public Proveedor guardarProveedor(Proveedor proveedor);
	
	public Proveedor obtenerProveedorPorId(Integer id);
	
	public Proveedor actualizarProveedor(Proveedor proveedor);
	
	public void eliminarProveedor(Integer id);
}
