package com.proyectoweb.curly.servicio;

import com.proyectoweb.curly.modelo.Categoria;
import com.proyectoweb.curly.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

	@Autowired
	private CategoriaRepositorio repositorio;
	@Override
	public List<Categoria> listarCategorias() {
		return repositorio.findAll();
	}

	@Override
	public Categoria guardarCategoria(Categoria categoria) {
		return repositorio.save(categoria);
	}

	@Override
	public Categoria obtenerCategoriaPorId(Integer id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		return repositorio.save(categoria);
	}

	@Override
	public void eliminarCategoria(Integer id) {
		repositorio.deleteById(id);
	}
}
