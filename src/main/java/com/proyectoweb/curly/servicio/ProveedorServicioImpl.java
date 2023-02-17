package com.proyectoweb.curly.servicio;


import com.proyectoweb.curly.modelo.Proveedor;
import com.proyectoweb.curly.repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicioImpl implements ProveedorServicio {

	@Autowired
	private ProveedorRepositorio repositorio;
	@Override
	public List<Proveedor> listarProveedor() {
		return repositorio.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		return repositorio.save(proveedor);
	}

	@Override
	public Proveedor obtenerProveedorPorId(Integer id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		return repositorio.save(proveedor);
	}

	@Override
	public void eliminarProveedor(Integer id) {
		repositorio.deleteById(id);
	}
}
