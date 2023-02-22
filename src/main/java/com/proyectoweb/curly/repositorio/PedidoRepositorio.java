package com.proyectoweb.curly.repositorio;

import com.proyectoweb.curly.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
}
