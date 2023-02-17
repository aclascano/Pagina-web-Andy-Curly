package com.proyectoweb.curly.repositorio;

import com.proyectoweb.curly.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository <Producto,Integer> {

}
