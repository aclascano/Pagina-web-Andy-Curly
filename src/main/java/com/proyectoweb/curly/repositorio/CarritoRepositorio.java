package com.proyectoweb.curly.repositorio;

import com.proyectoweb.curly.modelo.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepositorio extends JpaRepository<Carrito, Integer> {
}
