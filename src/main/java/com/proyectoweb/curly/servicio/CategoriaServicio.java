package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Categoria;

import java.util.List;

public interface CategoriaServicio {

	public List<Categoria> listarCategorias();
	
	public Categoria guardarCategoria(Categoria categoria);
	
	public Categoria obtenerCategoriaPorId(Integer id);
	
	public Categoria actualizarCategoria(Categoria categoria);
	
	public void eliminarCategoria(Integer id);
}
