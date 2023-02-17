package com.proyectoweb.curly.repositorio;

import com.proyectoweb.curly.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio  extends JpaRepository <Categoria,Integer> {

}
