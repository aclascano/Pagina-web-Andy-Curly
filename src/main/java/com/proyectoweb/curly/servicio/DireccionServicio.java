package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Categoria;
import com.proyectoweb.curly.modelo.Direccion;

import java.util.List;

public interface DireccionServicio {

	public List<Direccion> listarDirecciones();
	
	public Direccion guardarDireccion(Direccion direccion);
	
	public Direccion obtenerDireccionPorId(Integer id);
	
	public Direccion actualizarDireccion(Direccion direccion);
	
	public void eliminarDireccion(Integer id);

	public  List<Direccion> listarDireccionesPorClienteId(Integer idCliente);
}
