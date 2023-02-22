package com.proyectoweb.curly.repositorio;

import com.proyectoweb.curly.modelo.Carrito;
import com.proyectoweb.curly.modelo.Direccion;
import com.proyectoweb.curly.modelo.LineaPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineaRepositorio extends JpaRepository<LineaPedido,Integer> {

    @Query(value = "SELECT * FROM lineapedido WHERE id_car = :idCarrito", nativeQuery = true)
    List<LineaPedido> findByCarritoId(Integer idCarrito);

}
