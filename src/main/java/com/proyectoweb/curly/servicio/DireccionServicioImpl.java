package com.proyectoweb.curly.servicio;


import com.proyectoweb.curly.modelo.Direccion;
import com.proyectoweb.curly.repositorio.DireccionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServicioImpl implements DireccionServicio {

	@Autowired
	private DireccionRepositorio repositorio;

	@Override
	public List<Direccion> listarDirecciones() {
		return repositorio.findAll();
}

	@Override
	public Direccion guardarDireccion(Direccion direccion) {
		return repositorio.save(direccion);
	}

	@Override
	public Direccion obtenerDireccionPorId(Integer id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Direccion actualizarDireccion(Direccion direccion) {
		return repositorio.save(direccion);
	}

	@Override
	public void eliminarDireccion(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Direccion> listarDireccionesPorClienteId(Integer idCliente) {
		return repositorio.findByClientesId(idCliente);
	}
}
